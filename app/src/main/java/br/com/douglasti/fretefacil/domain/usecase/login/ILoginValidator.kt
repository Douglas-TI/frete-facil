package br.com.douglasti.fretefacil.domain.usecase.login

import br.com.douglasti.fretefacil.domain.usecase.ValidationResult

interface ILoginValidator {

    fun username(login: String): ValidationResult
    fun password(password: String): ValidationResult
    fun login(login: String, password: String): ValidationResult
}