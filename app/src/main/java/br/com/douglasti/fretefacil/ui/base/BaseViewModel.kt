package br.com.douglasti.fretefacil.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

open class BaseViewModel: ViewModel() {

    fun updateState(handler: suspend () -> Unit) {
        viewModelScope.launch {
            handler.invoke()
        }
    }
}