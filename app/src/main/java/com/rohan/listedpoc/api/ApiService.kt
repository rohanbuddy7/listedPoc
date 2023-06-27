package com.rohan.listedpoc.api

import com.rohan.listedpoc.data.response.DashboardResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import javax.inject.Singleton

@Singleton
interface ApiService {

    @GET("api/v1/dashboardNew")
    suspend fun getDashboard(
        @Header("Authorization") auth: String
    ): Response<DashboardResponse>

}