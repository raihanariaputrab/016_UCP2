package com.example.exercise2

import androidx.lifecycle.ViewModel
import com.example.exercise2.data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(OrderUIState())
    val stateUI : StateFlow<OrderUIState> = _stateUI.asStateFlow()

    fun setData(nama: String, nim: String, konsentrasi:String, judul:String){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                nama = nama,
                NIM = nim,
                Konsentrasi = konsentrasi,
                JudulSkripsi = judul
            )
        }
    }
    fun setDosen(dosenPilihan: String){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(DosPem = dosenPilihan)
        }
    }
    fun resetForm(){
        _stateUI.value = OrderUIState()
    }
}