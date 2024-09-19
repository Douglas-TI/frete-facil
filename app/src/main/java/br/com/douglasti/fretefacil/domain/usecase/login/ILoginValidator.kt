package br.com.douglasti.fretefacil.domain.usecase.login

import br.com.douglasti.fretefacil.domain.usecase.ValidationResult

interface ILoginValidator {

    fun validateLogin(login: String, password: String): ValidationResult
}