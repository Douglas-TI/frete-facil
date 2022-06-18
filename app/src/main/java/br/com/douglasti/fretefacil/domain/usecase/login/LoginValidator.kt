package br.com.douglasti.fretefacil.domain.usecase.login

import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.domain.usecase.ValidationResult
import br.com.douglasti.fretefacil.util.UiText
import javax.inject.Inject

class LoginValidator @Inject constructor(): ILoginValidator {

    override fun username(login: String): ValidationResult {
        if(login.isBlank())
            return ValidationResult(false, UiText.StringRes(R.string.required_field))

        return ValidationResult(true)
    }

    override fun password(password: String): ValidationResult {
        if(password.isBlank())
            return ValidationResult(false, UiText.StringRes(R.string.required_field))

        return ValidationResult(true)
    }

    override fun login(login: String, password: String): ValidationResult {
        return ValidationResult(true, UiText.DynamicString(""))
    }
}