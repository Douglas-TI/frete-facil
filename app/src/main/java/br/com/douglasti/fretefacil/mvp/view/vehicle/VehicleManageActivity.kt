package br.com.douglasti.fretefacil.mvp.view.vehicle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.douglasti.fretefacil.databinding.ActivityVehicleManageBinding
import br.com.douglasti.fretefacil.mvp.iface.IVehicleManageContract

class VehicleManageActivity : AppCompatActivity(), IVehicleManageContract.View {

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
        bind.ibAddVehicle.setOnClickListener { startActivity(intent) }
    }
}