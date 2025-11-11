package com.example.angelix_vasquez_ap2_p2.data.remote.api

import com.example.angelix_vasquez_ap2_p2.data.remote.dto.DepositoDto
import com.example.angelix_vasquez_ap2_p2.domain.model.Deposito
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DepositoApiServices {

    @GET("api/Depositos")
    suspend fun getDeposito() : List<DepositoDto>

    @POST("api/Depositos")
    suspend fun postDeposito(@Body deposito: DepositoDto)
}