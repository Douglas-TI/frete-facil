package br.com.douglasti.fretefacil.ui.vehicle.manage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.douglasti.fretefacil.data.model.entity.vehicle.Vehicle

class VehicleManageVM: ViewModel() {

     val vehicles = MutableLiveData<List<Vehicle>>()
}