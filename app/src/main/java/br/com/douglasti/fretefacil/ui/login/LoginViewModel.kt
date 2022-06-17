package br.com.douglasti.fretefacil.ui.login

import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.data.model.dto.state.LoginUiState
import br.com.douglasti.fretefacil.data.local.SharedPrefs
import br.com.douglasti.fretefacil.ui.base.BaseViewModel
import br.com.douglasti.fretefacil.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): BaseViewModel() {

    private val _loginFlow = MutableSharedFlow<LoginUiState>()
    val loginFlow = _loginFlow.asSharedFlow()

     fun autoLogin() {
        if(SharedPrefs.getUser().isEmpty())
            return

         val state = LoginUiState.OpenMenu(true)
         sendOneTimeEvent { _loginFlow.emit(state) }

    }

    fun setInitialData(usuario: String) {
        if (usuario.isBlank()) {
            val state = LoginUiState.Text(UiText.StringRes(R.string.required_field))
            sendOneTimeEvent { _loginFlow.emit(state) }

            return
        }

        SharedPrefs.setUser(usuario)
        val state = LoginUiState.OpenMenu(true)
        sendOneTimeEvent { _loginFlow.emit(state) }
    }
}