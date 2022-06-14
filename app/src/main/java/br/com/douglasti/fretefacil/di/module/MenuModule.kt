package br.com.douglasti.fretefacil.di.module

import br.com.douglasti.fretefacil.ui.menu.IMenuContract
import br.com.douglasti.fretefacil.ui.menu.MenuPresenter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class MenuModule {

    @Binds
    @ActivityScoped
    abstract fun presenter(presenter: MenuPresenter): IMenuContract.Presenter
}

