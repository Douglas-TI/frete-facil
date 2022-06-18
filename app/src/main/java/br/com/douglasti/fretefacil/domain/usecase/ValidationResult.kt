package br.com.douglasti.fretefacil.domain.usecase

import androidx.annotation.StringRes
import br.com.douglasti.fretefacil.util.UiText

data class ValidationResult (
    val sucess: Boolean,
    val message: UiText? = null
)