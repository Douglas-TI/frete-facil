package br.com.douglasti.fretefacil.modules

import br.com.douglasti.fretefacil.mvp.iface.IMenuContract
import br.com.douglasti.fretefacil.mvp.iface.IVehicleAddContract
import br.com.douglasti.fretefacil.mvp.presenter.MenuPresenter
import br.com.douglasti.fretefacil.mvp.presenter.VehicleAddPresenter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class VehicleAddModule {

    @Binds
    @ActivityScoped
    abstract fun presenter(presenter: VehicleAddPresenter): IVehicleAddContract.Presenter
}

