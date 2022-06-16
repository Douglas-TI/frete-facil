package br.com.douglasti.fretefacil.ui.login

import androidx.lifecycle.viewModelScope
import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.source.local.SharedPrefs
import br.com.douglasti.fretefacil.ui.base.BaseViewModel
import br.com.douglasti.fretefacil.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): BaseViewModel() {

     fun autoLogin() {
        if(SharedPrefs.getUser().isEmpty())
            return

        //view.openMenuActivity()
    }

    fun setInitialData(usuario: String) {
        if(usuario.isBlank()) {
            viewModelScope.launch {
                errorChannel.send(UiText.StringResource(R.string.required_field, "teste"))
            }

            return
        }

        SharedPrefs.setUser(usuario)
        //view.openMenuActivity()
    }
}