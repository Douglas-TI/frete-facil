package br.com.douglasti.fretefacil.data.usecase

import br.com.douglasti.fretefacil.R
import javax.inject.Inject

class LoginValidation @Inject constructor() {

    fun validate(login: String, password: String): ValidationResult {
        return ValidationResult(false, R.string.required_field)
    }
}