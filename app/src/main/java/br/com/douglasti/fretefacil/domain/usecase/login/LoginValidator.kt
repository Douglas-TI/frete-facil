package br.com.douglasti.fretefacil.domain.usecase.login

import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.domain.usecase.ValidationResult
import br.com.douglasti.fretefacil.util.UiText
import javax.inject.Inject

class LoginValidator @Inject constructor(): ILoginValidator {

    override fun validateLogin(login: String, password: String): ValidationResult {
        return ValidationResult(true, UiText.DynamicString(""))
    // if(login.isBlank())

    }
}