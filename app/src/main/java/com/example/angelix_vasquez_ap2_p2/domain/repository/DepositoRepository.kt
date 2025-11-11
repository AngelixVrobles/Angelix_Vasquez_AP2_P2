package com.example.angelix_vasquez_ap2_p2.domain.repository

import com.example.angelix_vasquez_ap2_p2.domain.model.Deposito

interface DepositoRepository {

    suspend fun getDeposito() : List<Deposito>
    suspend fun postDeposito (deposito : Deposito)
}