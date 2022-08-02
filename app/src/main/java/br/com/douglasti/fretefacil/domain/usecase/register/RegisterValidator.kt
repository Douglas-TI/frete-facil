package br.com.douglasti.fretefacil.domain.usecase.register

import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.domain.usecase.ValidationResult
import br.com.douglasti.fretefacil.util.UiText

class RegisterValidator: IRegisterValidator {

    override fun validate(etUser: String, etPassword: String, etConfirmPassword: String): ValidationResult {
        if(etUser.isBlank())
            return ValidationResult(false, UiText.StringRes(R.string.user_required))

        if(etPassword.isBlank())
            return ValidationResult(false, UiText.StringRes(R.string.password_required))

        if(etConfirmPassword.isBlank())
            return ValidationResult(false, UiText.StringRes(R.string.confirm_password_required))

        if(etPassword != etConfirmPassword)
            return ValidationResult(false, UiText.StringRes(R.string.password_confirm_different))

        return ValidationResult(true, null)
    }
}