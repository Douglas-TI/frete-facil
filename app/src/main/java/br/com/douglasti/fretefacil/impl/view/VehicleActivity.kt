package br.com.douglasti.fretefacil.impl.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.iface.IVehicleContract

class VehicleActivity : AppCompatActivity(), IVehicleContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle)
    }
}