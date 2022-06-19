package br.com.douglasti.fretefacil.ui.register

import br.com.douglasti.fretefacil.ui.base.BaseViewModel
import br.com.douglasti.fretefacil.ui.login.LoginUiEvent
import br.com.douglasti.fretefacil.ui.login.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): BaseViewModel() {

    private val _registerState = MutableStateFlow(LoginUiState())
    val registerState: StateFlow<LoginUiState> = _registerState

    private val _registerEvent = Channel<LoginUiEvent>()
    val registerEvent =  _registerEvent.receiveAsFlow()

    fun register() {

    }
}