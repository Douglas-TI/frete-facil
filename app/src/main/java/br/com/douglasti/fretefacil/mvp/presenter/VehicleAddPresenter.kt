package br.com.douglasti.fretefacil.mvp.presenter

import android.content.Context
import br.com.douglasti.fretefacil.mvp.iface.IVehicleAddContract
import br.com.douglasti.fretefacil.mvp.view.vehicle.VehicleAddActivity
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class VehicleAddPresenter @Inject constructor(@ActivityContext private val context: Context): IVehicleAddContract.Presenter {

    private val view: IVehicleAddContract.View = context as VehicleAddActivity

    override fun save() {

    }
}