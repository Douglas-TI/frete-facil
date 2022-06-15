package br.com.douglasti.fretefacil.ui.vehicle.manage

import android.content.Intent
import android.os.Bundle
import br.com.douglasti.fretefacil.databinding.ActivityVehicleManageBinding
import br.com.douglasti.fretefacil.ui.base.BaseAppCompactActivity
import br.com.douglasti.fretefacil.ui.vehicle.add.VehicleAddActivity
import br.com.douglasti.fretefacil.util.Constants

class VehicleManageActivity : BaseAppCompactActivity(), IVehicleManageContract.View {

    private lateinit var bind: ActivityVehicleManageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityVehicleManageBinding.inflate(layoutInflater)
        setContentView(bind.root)

        loadView()
    }

    private fun loadView() {
        setOpenVehicleAddActivity()
    }

    private fun setOpenVehicleAddActivity() {
        val intent = Intent(this, VehicleAddActivity::class.java)
            .putExtra(Constants.OPERATION_TYPE.description, Constants.NEW_REGISTER.value)

        bind.ibAddVehicle.setOnClickListener { startActivity(intent) }
    }
}