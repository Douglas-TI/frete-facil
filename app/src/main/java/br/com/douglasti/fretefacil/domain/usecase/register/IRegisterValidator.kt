package br.com.douglasti.fretefacil.domain.usecase.register

import br.com.douglasti.fretefacil.domain.usecase.ValidationResult

interface IRegisterValidator {

    fun validate(etUser: String, etPassword: String, etConfirmPassword: String): ValidationResult
}