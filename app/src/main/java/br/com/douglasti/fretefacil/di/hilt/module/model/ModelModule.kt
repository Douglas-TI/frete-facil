package br.com.douglasti.fretefacil.di.hilt.module.model

import br.com.douglasti.fretefacil.data.model.register.IRegisterModel
import br.com.douglasti.fretefacil.data.model.register.RegisterModel
import br.com.douglasti.fretefacil.domain.usecase.login.ILoginValidator
import br.com.douglasti.fretefacil.domain.usecase.login.LoginValidator
import br.com.douglasti.fretefacil.domain.usecase.register.IRegisterValidator
import br.com.douglasti.fretefacil.domain.usecase.register.RegisterValidator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ModelModule {

    @Binds
    @ViewModelScoped
    abstract fun registerModel(registerModel: RegisterModel): IRegisterModel
}