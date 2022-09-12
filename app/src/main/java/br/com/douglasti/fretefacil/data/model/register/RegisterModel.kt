package br.com.douglasti.fretefacil.data.model.register

import br.com.douglasti.fretefacil.domain.usecase.ValidationResult
import br.com.douglasti.fretefacil.domain.usecase.register.IRegisterValidator
import javax.inject.Inject

class RegisterModel @Inject constructor(): IRegisterModel {

    @Inject
    lateinit var registerValidator: IRegisterValidator

    override fun registerValidator(username: String, password: String, confirmPassword: String): ValidationResult {
        return registerValidator.validate(username, password, confirmPassword)
    }
}