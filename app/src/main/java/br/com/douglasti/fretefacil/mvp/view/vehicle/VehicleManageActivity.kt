package br.com.douglasti.fretefacil.mvp.view.vehicle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.douglasti.fretefacil.databinding.ActivityVehicleManageBinding
import br.com.douglasti.fretefacil.mvp.iface.IVehicleManageContract
import br.com.douglasti.fretefacil.mvp.view.BaseAppCompactActivity
import br.com.douglasti.fretefacil.mvp.view.vehicle.vehicleAdd.VehicleAddActivity
import br.com.douglasti.fretefacil.util.Constantes

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
            .putExtra(Constantes.OPERATION_TYPE.description, Constantes.NEW_REGISTER.value)

        bind.ibAddVehicle.setOnClickListener { startActivity(intent) }
    }
}