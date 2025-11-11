package com.example.angelix_vasquez_ap2_p2.data.remote.dto

import com.example.angelix_vasquez_ap2_p2.domain.model.Deposito

class DepositoDto (
    val depositoId : Int,
    val fecha : String,
    val monto : Int,
    val banco : String,
    val concepto : String
)

{
    fun toDomain() = Deposito(depositoId, fecha, monto, banco, concepto)
}

fun Deposito.toDto() = DepositoDto(depositoId,fecha,monto,banco,concepto)