package br.com.douglasti.fretefacil.mvp.view.vehicle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.douglasti.fretefacil.databinding.ActivityVehicleAddBinding

class VehicleAddActivity : AppCompatActivity() {

    private lateinit var bind: ActivityVehicleAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityVehicleAddBinding.inflate(layoutInflater)
        setContentView(bind.root)

        loadView()
    }

    private fun loadView() {

    }
}