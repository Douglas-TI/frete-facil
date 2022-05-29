package br.com.douglasti.fretefacil.hilt.vehicleadd

import br.com.douglasti.fretefacil.mvp.iface.IVehicleAddContract
import br.com.douglasti.fretefacil.mvp.presenter.VehicleAddPresenter
import dagger.assisted.AssistedFactory

@AssistedFactory
interface IVehicleAddFactory {

    fun createPresenter(view: IVehicleAddContract.View): VehicleAddPresenter
}