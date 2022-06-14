package br.com.douglasti.fretefacil.di.factory

import br.com.douglasti.fretefacil.ui.vehicle.add.IVehicleAddContract
import br.com.douglasti.fretefacil.ui.vehicle.add.VehicleAddPresenter
import dagger.assisted.AssistedFactory

@AssistedFactory
interface IVehicleAddFactory {

    fun createPresenter(view: IVehicleAddContract.View): VehicleAddPresenter
}