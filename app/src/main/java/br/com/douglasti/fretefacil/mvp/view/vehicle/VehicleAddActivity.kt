package br.com.douglasti.fretefacil.mvp.view.vehicle

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.databinding.ActivityVehicleAddBinding
import br.com.douglasti.fretefacil.mvp.iface.IVehicleAddContract
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@Suppress("ProtectedInFinal")
@AndroidEntryPoint
class VehicleAddActivity : AppCompatActivity(), IVehicleAddContract.View {

    private lateinit var bind: ActivityVehicleAddBinding
    @Inject protected lateinit var presenter: IVehicleAddContract.Presenter

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_save, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        /*if (id == R.id.bt_save){

        }*/
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityVehicleAddBinding.inflate(layoutInflater)
        setContentView(bind.root)

        loadView()
    }

    private fun loadView() {

    }

    override fun getStringEtBrand() = bind.etBrand.text.toString()

    override fun getStringEtModel() = bind.etModel.text.toString()

    override fun getStringEtKml() = bind.etKml.text.toString()

    override fun getStringEtMaitenanceCost() = bind.etMaitenanceCost.text.toString()

    override fun getStringEtMaitenanceCostMonths() = bind.etMaitenanceCostMonths.text.toString()
}