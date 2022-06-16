package br.com.douglasti.fretefacil.model.dto

import br.com.douglasti.fretefacil.util.UiText

sealed class LoginUiState {

    data class Text(val uiText: UiText): LoginUiState()
    data class OpenMenu(val boolean: Boolean? = null): LoginUiState()
}
