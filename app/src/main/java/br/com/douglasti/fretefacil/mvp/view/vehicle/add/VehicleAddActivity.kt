package br.com.douglasti.fretefacil.mvp.view.vehicle.add

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.databinding.ActivityVehicleAddBinding
import br.com.douglasti.fretefacil.hilt.vehicleadd.IVehicleAddFactory
import br.com.douglasti.fretefacil.mvp.iface.contract.IVehicleAddContract
import br.com.douglasti.fretefacil.mvp.model.data.entities.Fuel
import br.com.douglasti.fretefacil.mvp.view.BaseAppCompactActivity
import br.com.douglasti.fretefacil.util.Constantes
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@Suppress("ProtectedInFinal")
@AndroidEntryPoint
class VehicleAddActivity : BaseAppCompactActivity(), IVehicleAddContract.View {

    @Inject
    protected lateinit var vehicleAddFactory: IVehicleAddFactory
    private lateinit var presenter: IVehicleAddContract.Presenter
    private lateinit var fuelAdapter: VehicleAddFuelAdapter

    private lateinit var bind: ActivityVehicleAddBinding

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_save, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if (id == R.id.bt_save)
            presenter.confirmVehicle()

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
        presenter.load()

        buildFuelAdapter()
        setFuelAddButton()
    }

    override fun getOperationType() = intent.extras?.getString(Constantes.OPERATION_TYPE.description)

    private fun buildFuelAdapter() {
        fuelAdapter = VehicleAddFuelAdapter(presenter)

        bind.rvFuel.setHasFixedSize(true)
        bind.rvFuel.layoutManager = LinearLayoutManager(this)
        bind.rvFuel.addItemDecoration(DividerItemDecoration(bind.rvFuel.context, DividerItemDecoration.VERTICAL))
        bind.rvFuel.adapter = fuelAdapter
    }

    override fun getFuelList() = fuelAdapter.getList()

    override fun addFuel(fuel: Fuel) { fuelAdapter.addFuel(fuel) }

    override fun getStringEtBrand() = bind.etBrand.text.toString()
    override fun setErrorEtBrand(error: String) { bind.etBrand.error = error }

    override fun getStringEtModel() = bind.etModel.text.toString()
    override fun setErrorEtModel(error: String) { bind.etModel.error = error }

    override fun setArraySpinnerFuelType(array: Array<String>) {
        bind.spinnerFuelTypes.adapter = getDefaultSpinnerAdapter(array)
    }
    override fun getStringSpinnerFuelType() = bind.spinnerFuelTypes.selectedItem.toString()
    override fun setErrorSpinnerFuelType(error: String) {
        (bind.spinnerFuelTypes.selectedView as TextView).error = error
    }

    override fun getDoubleEtFuelKml() = bind.etFuelKml.text.toString().toDouble()
    override fun setErrorEtFuelKml(error: String) { bind.etFuelKml.error = error }

    private fun setFuelAddButton() = bind.ibFuelAdd.setOnClickListener { presenter.addFuel() }

    override fun setVisibilityFuelRequired(visibility: Int) {
        bind.tvRequiredFuel.visibility = visibility
    }

    override fun getStringEtMaitenanceCost() = bind.etMaitenanceCost.text.toString()
    override fun setErrorEtMaitenanceCost(error: String) { bind.etMaitenanceCost.error = error }

    override fun getStringEtMaitenanceFrequency() = bind.etMaitenanceCostMonths.text.toString()
    override fun setErrorEtMaitenanceFrequency(error: String) { bind.etMaitenanceCostMonths.error = error }
}