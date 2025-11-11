package com.example.angelix_vasquez_ap2_p2.data.repository

import com.example.angelix_vasquez_ap2_p2.data.remote.api.DepositoApiServices
import com.example.angelix_vasquez_ap2_p2.data.remote.dto.toDto
import com.example.angelix_vasquez_ap2_p2.domain.model.Deposito
import com.example.angelix_vasquez_ap2_p2.domain.repository.DepositoRepository

class DepositoRepositoryImp (private val api : DepositoApiServices) : DepositoRepository {
    override suspend fun getDeposito(): List<Deposito> {
        return api.getDeposito().map {it.toDomain()}
    }

    override suspend fun postDeposito(deposito: Deposito) {
        api.postDeposito(deposito.toDto())
    }
}