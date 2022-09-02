package br.com.douglasti.fretefacil.di.hilt.module

import br.com.douglasti.fretefacil.domain.usecase.login.ILoginValidator
import br.com.douglasti.fretefacil.domain.usecase.login.LoginValidator
import br.com.douglasti.fretefacil.domain.usecase.register.IRegisterValidator
import br.com.douglasti.fretefacil.domain.usecase.register.RegisterValidator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun loginValidator(loginValidator: LoginValidator): ILoginValidator

    @Binds
    @ViewModelScoped
    abstract fun registerValidator(registerValidator: RegisterValidator): IRegisterValidator
}