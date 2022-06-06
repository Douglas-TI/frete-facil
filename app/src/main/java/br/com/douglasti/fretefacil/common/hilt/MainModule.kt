package br.com.douglasti.fretefacil.common.hilt

import br.com.douglasti.fretefacil.mvp.iface.contract.IMainContract
import br.com.douglasti.fretefacil.mvp.iface.contract.IMenuContract
import br.com.douglasti.fretefacil.mvp.presenter.MainPresenter
import br.com.douglasti.fretefacil.mvp.presenter.MenuPresenter
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
    abstract fun presenter(presenter: MainPresenter): IMainContract.Presenter
}

