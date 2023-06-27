package com.rohan.listedpoc.ui.links

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rohan.listedpoc.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LinksViewModel @Inject constructor(var homeRepository: HomeRepository): ViewModel() {

    fun getDashboard(){
        viewModelScope.launch{
            homeRepository.getDashboard()
                .collect(){

                }
        }
    }

}