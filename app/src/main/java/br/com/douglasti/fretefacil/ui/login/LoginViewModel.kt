package br.com.douglasti.fretefacil.ui.login

import android.view.View
import androidx.lifecycle.viewModelScope
import br.com.douglasti.fretefacil.R

import br.com.douglasti.fretefacil.data.local.SharedPrefs
import br.com.douglasti.fretefacil.domain.usecase.login.ILoginValidator

import br.com.douglasti.fretefacil.ui.base.ExtensionViewModel
import br.com.douglasti.fretefacil.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    var loginValidator: ILoginValidator
): ExtensionViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    private val _uiEvent = Channel<LoginUiEvent>()
    val uiEvent =  _uiEvent.receiveAsFlow()

    fun autoLogin() {
        if(SharedPrefs.getUser().isEmpty())
            return

        viewModelScope.launch {
            _uiEvent.send(LoginUiEvent.ShowToast(UiText.StringRes(R.string.login_successful)))
            _uiEvent.send(LoginUiEvent.OpenMenu)
        }
    }

    fun login(username: String, password: String) {
        if(! validateFieldsLogin(username, password)) {

            return
        }

        _uiState.value = uiState.value.copy(loading = View.VISIBLE)
    }

    private fun validateFieldsLogin(username: String, password: String): Boolean {
        if(username.isEmpty()) {
            _uiState.update { it.copy(etUsernameError = UiText.StringRes(R.string.required_field)) }
            return
        }

        if(username.isEmpty()) {
            _uiState.update { it.copy(etUsernameError = UiText.StringRes(R.string.required_field)) }
            return
        }
    }

    private fun validateUsername(username: String): Boolean {
        /*val validationResult = loginValidator.username(username)
        if(! validationResult.sucess) {
            _loginState.update { it.copy(emptyUserErrorMsg = validationResult.message, loading = false) }

            return false
        }
        _loginState.update { it.copy(emptyUserErrorMsg = null, loading = false) }
        */
        return true
    }

    private fun validatePassword(password: String): Boolean {
       /* val validationResult = loginValidator.password(password)
        if(! validationResult.sucess) {
            _loginState.update { it.copy(emptyPasswordErrorMsg = validationResult.message, loading = false) }

            return false
        }
        _loginState.update { it.copy(emptyPasswordErrorMsg = null, loading = false) }
        */
        return true
    }

    /*private fun validateLogin(username: String, password: String) {
        val validationResult = loginValidator.login(username, password)
        if(! validationResult.sucess) {
            _loginState.update { it.copy(emptyCredentialsErrorMsg = validationResult.message, loading = false) }
            return
        }
        _loginState.update { it.copy(emptyCredentialsErrorMsg = null, loading = false) }

        SharedPrefs.setUser(username)
        viewModelScope.launch {
            _loginEvent.send(LoginUiEvent.LoginSucessful)
            _loginEvent.send(LoginUiEvent.ClearUserField)
            _loginEvent.send(LoginUiEvent.ClearPasswordField)
        }
    }*/
}

data class LoginUiState(
    val etUsernameError: UiText? = null,
    val etPasswordError: UiText? = null,
    val emptyCredentialsErrorMsg: UiText? = null,
    val loading: Int = View.INVISIBLE
)

open class LoginUiEvent {
    class ShowToast(val text: UiText): LoginUiEvent()
    class ShowAlert(val text: UiText): LoginUiEvent()
    object OpenMenu: LoginUiEvent()
    object ClearUserField: LoginUiEvent()
    object ClearPasswordField: LoginUiEvent()
}

