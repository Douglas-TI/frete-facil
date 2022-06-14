package br.com.douglasti.fretefacil.di.module

import br.com.douglasti.fretefacil.ui.login.ILoginContract
import br.com.douglasti.fretefacil.ui.login.LoginPresenter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class MainModule {

    @Binds
    @ActivityScoped
    abstract fun presenter(presenter: LoginPresenter): ILoginContract.Presenter
}

