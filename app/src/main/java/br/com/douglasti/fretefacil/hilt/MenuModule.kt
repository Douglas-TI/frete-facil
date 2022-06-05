package br.com.douglasti.fretefacil.hilt

import br.com.douglasti.fretefacil.mvp.iface.contract.IMenuContract
import br.com.douglasti.fretefacil.mvp.presenter.MenuPresenter
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

