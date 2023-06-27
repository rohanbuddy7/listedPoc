package com.rohan.listedpoc.ui.links

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rohan.listedpoc.data.response.DashboardResponse
import com.rohan.listedpoc.repository.HomeRepository
import com.rohan.listedpoc.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class LinksViewModel @Inject constructor(var homeRepository: HomeRepository): ViewModel() {

    private var _dashboardRes: MutableStateFlow<NetworkResult<DashboardResponse>> = MutableStateFlow(NetworkResult.Loading());
    var dashboardRes: StateFlow<NetworkResult<DashboardResponse>> = _dashboardRes

    fun getDashboard(){
        viewModelScope.launch{
            homeRepository.getDashboard()
                .collect(){ response ->
                    if(response.isSuccessful && response.body()!=null){
                        _dashboardRes.emit(NetworkResult.Success(response.body()))
                    } else if(response.errorBody()!=null){
                        val error = JSONObject(response.errorBody()!!.charStream().readText())
                        _dashboardRes.emit(NetworkResult.Error(error.getString("message")))
                    } else {
                        _dashboardRes.emit(NetworkResult.Error("Something went wrong"));
                    }
                }
        }
    }

}