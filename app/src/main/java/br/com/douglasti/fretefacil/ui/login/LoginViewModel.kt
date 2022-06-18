package br.com.douglasti.fretefacil.ui.login

import androidx.annotation.StringRes
import androidx.lifecycle.viewModelScope

import br.com.douglasti.fretefacil.data.local.SharedPrefs
import br.com.douglasti.fretefacil.data.usecase.LoginValidation

import br.com.douglasti.fretefacil.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(@Inject var loginValidation: LoginValidation): BaseViewModel() {

    private val _loginState = MutableStateFlow(LoginUiState())
    val loginState: StateFlow<LoginUiState> = _loginState

    private val _loginEvent = Channel<LoginUiEvent>()
    val loginEvent =  _loginEvent.receiveAsFlow()

    fun autoLogin() {
        if(SharedPrefs.getUser().isEmpty())
            return

     /*val state = LoginUiState.OpenMenu(true)
     sendOneTimeEvent { _loginFlow.emit(state) }*/


    }

    fun login(usuario: String) = viewModelScope.launch {
       val validationResult = loginValidation.validate(usuario, "")
       if(! validationResult.sucessful) {
           _loginState.update {
               it.copy(userErrorMessage = validationResult.errorMessage)
           }

           return@launch
       }

        SharedPrefs.setUser(usuario)
        _loginState.update {
            it.copy(userErrorMessage = null) //UiText
        }
        _loginEvent.send(LoginUiEvent.loginSucessful)
    }
}

data class LoginUiState(
    @StringRes val userErrorMessage: Int? = null
)

open class LoginUiEvent {
    object loginSucessful: LoginUiEvent()
}

