package br.com.douglasti.fretefacil.data.model.register

import br.com.douglasti.fretefacil.domain.usecase.ValidationResult

interface IRegisterModel {

    fun registerValidator(username: String, password: String, confirmPassword: String): ValidationResult
}