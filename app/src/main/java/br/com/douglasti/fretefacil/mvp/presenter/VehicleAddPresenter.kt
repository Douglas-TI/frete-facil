package br.com.douglasti.fretefacil.mvp.presenter

import android.content.Context
import android.util.Log
import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.mvp.iface.IVehicleAddContract
import br.com.douglasti.fretefacil.mvp.view.vehicle.VehicleAddActivity
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class VehicleAddPresenter @AssistedInject constructor(@Assisted val view: IVehicleAddContract.View,
                                                      @ActivityContext val context: Context ): IVehicleAddContract.Presenter {

    override fun validateSave() {
        if(view.getStringEtBrand().isEmpty()) {
            view.setErrorEtBrand(context.getString(R.string.requiredField))
            return
        }

        if(view.getStringEtModel().isEmpty()) {
            view.setErrorEtModel(context.getString(R.string.requiredField))
            return
        }
    }
}