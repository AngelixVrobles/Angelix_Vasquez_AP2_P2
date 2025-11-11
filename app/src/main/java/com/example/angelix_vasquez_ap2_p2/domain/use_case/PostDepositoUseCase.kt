package com.example.angelix_vasquez_ap2_p2.domain.use_case

import com.example.angelix_vasquez_ap2_p2.domain.model.Deposito
import com.example.angelix_vasquez_ap2_p2.domain.repository.DepositoRepository
import javax.inject.Inject

class PostDepositoUseCase @Inject constructor(private val repository: DepositoRepository) {
    suspend operator fun invoke(desposito : Deposito) = repository.postDeposito(desposito)
}