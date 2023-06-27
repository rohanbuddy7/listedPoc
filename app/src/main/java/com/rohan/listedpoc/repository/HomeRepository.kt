package com.rohan.listedpoc.repository

import com.rohan.listedpoc.MyApplication
import com.rohan.listedpoc.api.ApiService
import com.rohan.listedpoc.data.response.DashboardResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class HomeRepository @Inject constructor(var apiService: ApiService) {

    fun getDashboard(): Flow<Response<DashboardResponse>> {
        return flow {
            emit(apiService.getDashboard("Bearer ${MyApplication.token}"))
        }
    }

}