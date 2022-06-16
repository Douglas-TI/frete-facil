package br.com.douglasti.fretefacil.ui.login

import android.util.Log
import androidx.lifecycle.viewModelScope
import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.model.dto.LoginUiState
import br.com.douglasti.fretefacil.source.local.SharedPrefs
import br.com.douglasti.fretefacil.ui.base.BaseViewModel
import br.com.douglasti.fretefacil.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): BaseViewModel() {

    private val uiChannel = Channel<LoginUiState>()
    val uiFlow = uiChannel.receiveAsFlow()

     fun autoLogin() {
        if(SharedPrefs.getUser().isEmpty())
            return

         viewModelScope.launch {
             val state = LoginUiState.OpenMenu(true)
             uiChannel.send(state)
         }
    }

    fun setInitialData(usuario: String) =
        viewModelScope.launch {
            if (usuario.isBlank()) {
                val state = LoginUiState.Text(UiText.StringResource(R.string.required_field))
                uiChannel.send(state)

                return@launch
            }

            SharedPrefs.setUser(usuario)
            val state = LoginUiState.OpenMenu(true)
            uiChannel.send(state)
        }
}