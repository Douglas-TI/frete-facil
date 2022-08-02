package br.com.douglasti.fretefacil.ui.register

import androidx.lifecycle.viewModelScope
import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.domain.usecase.ValidationResult
import br.com.douglasti.fretefacil.domain.usecase.register.IRegisterValidator
import br.com.douglasti.fretefacil.ui.base.BaseViewModel
import br.com.douglasti.fretefacil.ui.login.LoginUiEvent
import br.com.douglasti.fretefacil.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): BaseViewModel() {

    @Inject lateinit var registerValidator: IRegisterValidator

    private val _registerState = MutableStateFlow(RegisterUiState())
    val registerState: StateFlow<RegisterUiState> = _registerState

    private val _registerEvent = Channel<RegisterUiEvent>()
    val registerEvent =  _registerEvent.receiveAsFlow()

    fun register(etUser: String, etPassword: String, etConfirmPassword: String) {
        clearState()

        val result = registerValidator.validate(etUser, etPassword, etConfirmPassword)
        if(! result.sucess)
            handleRegisterError(result)

        viewModelScope.launch { _registerEvent.send(RegisterUiEvent.registerSuccessful) }
    }

    private fun handleRegisterError(result: ValidationResult) = when(result.message?.asResource()) {
        R.string.user_required -> {
            _registerState.update { it.copy(loading = false, userRequiredErrorMsg = result.message) }
        }
        R.string.password_required -> {
            _registerState.update { it.copy(loading = false, passwordRequiredErrorMsg = result.message) }
        }
        R.string.confirm_password_required -> {
            _registerState.update { it.copy(loading = false, confirmPasswordRequiredErrorMsg = result.message) }
        }
        R.string.password_confirm_different -> {
            _registerState.update { it.copy(loading = false, passwordConfirmDifferentErrorMsg = result.message) }
        }
        else -> {}
    }

    private fun clearState() = _registerState.update {
        it.copy(
            loading = false,
            userRequiredErrorMsg = null,
            passwordRequiredErrorMsg = null,
            confirmPasswordRequiredErrorMsg = null,
            passwordConfirmDifferentErrorMsg = null
        )
    }
}

data class RegisterUiState(
    val loading: Boolean = false,
    val userRequiredErrorMsg: UiText? = null,
    val passwordRequiredErrorMsg: UiText? = null,
    val confirmPasswordRequiredErrorMsg: UiText? = null,
    val passwordConfirmDifferentErrorMsg: UiText? = null
)

sealed class RegisterUiEvent {
    object registerSuccessful: RegisterUiEvent()
}