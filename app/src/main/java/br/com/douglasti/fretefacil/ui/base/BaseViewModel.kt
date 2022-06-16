package br.com.douglasti.fretefacil.ui.base

import androidx.lifecycle.ViewModel
import br.com.douglasti.fretefacil.util.UiText
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

open class BaseViewModel: ViewModel() {

    protected val errorChannel = Channel<UiText>()
    val errors = errorChannel.receiveAsFlow()
}