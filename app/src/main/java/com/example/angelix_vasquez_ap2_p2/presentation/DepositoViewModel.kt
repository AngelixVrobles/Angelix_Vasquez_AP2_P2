package com.example.angelix_vasquez_ap2_p2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.angelix_vasquez_ap2_p2.domain.model.Deposito
import com.example.angelix_vasquez_ap2_p2.domain.use_case.GetDepositoUseCase
import com.example.angelix_vasquez_ap2_p2.domain.use_case.PostDepositoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DepositoViewModel (
    private val getDepositoUseCase: GetDepositoUseCase,
    private val postDepositoUseCase: PostDepositoUseCase
) : ViewModel() {

    private val _depositos = MutableStateFlow<List<Deposito>>(emptyList())
    val depositos: StateFlow<List<Deposito>> = _depositos

    private val _mensaje = MutableStateFlow<String?>(null)
    val mensaje: StateFlow<String?> = _mensaje

    fun cargarDepositos(){
        viewModelScope.launch {
            try {
                _depositos.value = getDepositoUseCase()
            } catch (e: Exception){
                _mensaje.value = "Error: ${e.message}"
            }
        }
    }

    fun enviarDepositos(){
        viewModelScope.launch {
            try {
                cargarDepositos()
                postDepositoUseCase
            }catch (e: Exception){
                _mensaje.value = "Error al enviar mensaje: ${e.message}"
            }
        }
    }
}
