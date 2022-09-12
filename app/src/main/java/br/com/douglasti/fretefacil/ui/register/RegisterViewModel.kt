package br.com.douglasti.fretefacil.ui.register

import androidx.lifecycle.viewModelScope
import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.domain.usecase.ValidationResult
import br.com.douglasti.fretefacil.domain.usecase.register.IRegisterValidator
import br.com.douglasti.fretefacil.ui.base.BaseViewModel
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
        handleRegisterError(result)
    }

    private fun handleRegisterError(result: ValidationResult) {
        when (result.message?.asResource()) {
            R.string.user_required -> {
                _registerState.update { it.copy(loading = false, userRequiredErrorMsg = result.message) }
            }
            R.string.password_required -> {
                _registerState.update { it.copy(loading = false, passwordRequiredErrorMsg = result.message) }
            }
            R.string.confirm_password_required -> {
                _registerState.update { it.copy(loading = false, passwordConfirmationRequiredErrorMsg = result.message) }
            }
            R.string.password_confirm_different -> {
                _registerState.update { it.copy(loading = false, passwordConfirmationDifferentErrorMsg = result.message) }
            }
            else -> {
                viewModelScope.launch {
                    _registerEvent.send(RegisterUiEvent.RegisterSuccessful(result.message))
                }
            }
        }
    }

    fun clearState() = _registerState.update {
        it.copy(
            loading = false,
            userRequiredErrorMsg = null,
            passwordRequiredErrorMsg = null,
            passwordConfirmationRequiredErrorMsg = null,
            passwordConfirmationDifferentErrorMsg = null
        )
    }
}

data class RegisterUiState(
    val userRequiredErrorMsg: UiText? = null,
    val passwordRequiredErrorMsg: UiText? = null,
    val passwordConfirmationRequiredErrorMsg: UiText? = null,
    val passwordConfirmationDifferentErrorMsg: UiText? = null,
    val loading: Boolean = false
)

sealed class RegisterUiEvent {
    class RegisterSuccessful(val msg: UiText?) : RegisterUiEvent()
}