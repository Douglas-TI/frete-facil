package br.com.douglasti.fretefacil.data.usecase

import androidx.annotation.StringRes

data class ValidationResult (
    val sucessful: Boolean,
    @StringRes val errorMessage: Int? = null
)