package com.example.angelix_vasquez_ap2_p2.domain.use_case

import com.example.angelix_vasquez_ap2_p2.domain.repository.DepositoRepository
import javax.inject.Inject

class GetDepositoUseCase @Inject constructor(private val repository: DepositoRepository) {
    suspend operator fun invoke() = repository.getDeposito()
}