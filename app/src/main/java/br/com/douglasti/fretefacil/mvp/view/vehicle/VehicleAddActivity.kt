package br.com.douglasti.fretefacil.mvp.view.vehicle

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.databinding.ActivityVehicleAddBinding
import br.com.douglasti.fretefacil.hilt.vehicleadd.IVehicleAddFactory
import br.com.douglasti.fretefacil.mvp.iface.IVehicleAddContract
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@Suppress("ProtectedInFinal")
@AndroidEntryPoint
class VehicleAddActivity : AppCompatActivity(), IVehicleAddContract.View {

    @Inject
    protected lateinit var vehicleAddFactory: IVehicleAddFactory
    protected lateinit var presenter: IVehicleAddContract.Presenter

    private lateinit var bind: ActivityVehicleAddBinding

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_save, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if (id == R.id.bt_save)
            presenter.validateSave()

        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityVehicleAddBinding.inflate(layoutInflater)
        setContentView(bind.root)

        loadView()
    }

    private fun loadView() {
        presenter = vehicleAddFactory.createPresenter(this)
    }

    override fun getStringEtBrand() = bind.etBrand.text.toString()
    override fun setErrorEtBrand(error: String) { bind.etBrand.error = error }

    override fun getStringEtModel() = bind.etModel.text.toString()
    override fun setErrorEtModel(error: String) { bind.etModel.error = error }

    override fun getStringEtKml() = bind.etKml.text.toString()
    override fun setErrorEtKml(error: String) { bind.etKml.error = error }

    override fun getStringEtMaitenanceCost() = bind.etMaitenanceCost.text.toString()
    override fun setErrorEtMaitenanceCost(error: String) { bind.etMaitenanceCost.error = error }

    override fun getStringEtMaitenanceCostMonths() = bind.etMaitenanceCostMonths.text.toString()
    override fun setErrorEtMaitenanceCostMonths(error: String) { bind.etMaitenanceCostMonths.error = error }
}