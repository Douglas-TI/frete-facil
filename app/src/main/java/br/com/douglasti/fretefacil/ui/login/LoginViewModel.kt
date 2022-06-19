package br.com.douglasti.fretefacil.ui.login

import androidx.lifecycle.viewModelScope

import br.com.douglasti.fretefacil.data.local.SharedPrefs
import br.com.douglasti.fretefacil.domain.usecase.login.ILoginValidator

import br.com.douglasti.fretefacil.ui.base.BaseViewModel
import br.com.douglasti.fretefacil.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): BaseViewModel() {

    @Inject lateinit var loginValidator: ILoginValidator

    private val _loginState = MutableStateFlow(LoginUiState())
    val loginState: StateFlow<LoginUiState> = _loginState

    private val _loginEvent = Channel<LoginUiEvent>()
    val loginEvent =  _loginEvent.receiveAsFlow()

    fun autoLogin() {
        if(SharedPrefs.getUser().isEmpty())
            return

        viewModelScope.launch { _loginEvent.send(LoginUiEvent.LoginSucessful) }
    }

    fun login(username: String, password: String) {
        _loginState.update { it.copy(loading = true) }

        val isValidUsername = validateUsername(username)
        val isValidPassword = validatePassword(password)

        if(isValidUsername && isValidPassword)
            validateLogin(username, password)
    }

    private fun validateUsername(username: String): Boolean {
        val validationResult = loginValidator.username(username)
        if(! validationResult.sucess) {
            _loginState.update { it.copy(emptyUserMsg = validationResult.message, loading = false) }

            return false
        }
        _loginState.update { it.copy(emptyUserMsg = null, loading = false) }

        return true
    }

    private fun validatePassword(password: String): Boolean {
        val validationResult = loginValidator.password(password)
        if(! validationResult.sucess) {
            _loginState.update { it.copy(emptyPasswordMsg = validationResult.message, loading = false) }

            return false
        }
        _loginState.update { it.copy(emptyPasswordMsg = null, loading = false) }

        return true
    }

    private fun validateLogin(username: String, password: String) {
        val validationResult = loginValidator.login(username, password)
        if(! validationResult.sucess) {
            _loginState.update { it.copy(emptyCredentialsMsg = validationResult.message, loading = false) }
            return
        }
        _loginState.update { it.copy(emptyCredentialsMsg = null, loading = false) }

        SharedPrefs.setUser(username)
        viewModelScope.launch {
            _loginEvent.send(LoginUiEvent.LoginSucessful)
            _loginEvent.send(LoginUiEvent.ClearUserField)
            _loginEvent.send(LoginUiEvent.ClearPasswordField)
        }
    }
}

data class LoginUiState(
    val emptyUserMsg: UiText? = null,
    val emptyPasswordMsg: UiText? = null,
    val emptyCredentialsMsg: UiText? = null,
    val loading: Boolean = false
)

open class LoginUiEvent {
    object LoginSucessful: LoginUiEvent()
    object ClearUserField: LoginUiEvent()
    object ClearPasswordField: LoginUiEvent()
}

