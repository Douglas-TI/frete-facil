package br.com.douglasti.fretefacil.data.model.dto.state

import br.com.douglasti.fretefacil.data.model.dto.Route
import br.com.douglasti.fretefacil.util.UiText

sealed class LoginUiState {

    data class Text(val uiText: UiText): LoginUiState()
    data class OpenMenu(val boolean: Boolean? = null): LoginUiState()
    data class RouteState(val route: Route)
}
