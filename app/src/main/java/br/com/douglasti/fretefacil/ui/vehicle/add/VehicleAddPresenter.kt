package br.com.douglasti.fretefacil.ui.vehicle.add

import android.content.Context
import android.view.View
import androidx.room.Room
import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.source.local.room.AppDatabase
import br.com.douglasti.fretefacil.model.entity.vehicle.Fuel
import br.com.douglasti.fretefacil.model.entity.vehicle.FuelConstant
import br.com.douglasti.fretefacil.model.entity.vehicle.Maitenance
import br.com.douglasti.fretefacil.model.entity.vehicle.Vehicle
import br.com.douglasti.fretefacil.util.Constants
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dagger.hilt.android.qualifiers.ActivityContext

class VehicleAddPresenter @AssistedInject constructor(@Assisted val view: IVehicleAddContract.View,
                                                      @ActivityContext val context: Context ): IVehicleAddContract.Presenter {

    override fun load() {
        populateSpinnerFuel()
    }

    private fun populateSpinnerFuel() {
        val db = Room.databaseBuilder(context, AppDatabase::class.java, "database-name").build()
        val fuelConstantTest = FuelConstant("Gasolina")

        val t = Thread {
            db.fuelConstantDao().insertAll(fuelConstantTest)
            val fuelsConstant: List<FuelConstant> = db.fuelConstantDao().getAll()
        }

        t.start()

        val array = arrayOf("Gasolina", "Alcool", "Diesel")
        view.setArraySpinnerFuelType(array)
    }

    override fun confirmVehicle() {
        val vehicle = buildVehicle()

        if(! validateVehicle(vehicle))
            return

        if(view.getOperationType() == Constants.NEW_REGISTER.description)
            saveVehicle(vehicle)
        else
            editVehicle(vehicle)
    }

    private fun validateVehicle(vehicle: Vehicle): Boolean {
        var errors = 0

        view.setVisibilityFuelRequired(View.GONE)

        if(vehicle.brand.isEmpty()) {
            view.setErrorEtBrand(context.getString(R.string.required_field))
            errors++
        }

        if(vehicle.model.isEmpty()) {
            view.setErrorEtModel(context.getString(R.string.required_field))
            errors++
        }

        if(vehicle.fuels.isEmpty()) {
            view.setVisibilityFuelRequired(View.VISIBLE)
            errors++
        }

        return errors == 0
    }

    private fun buildVehicle(): Vehicle {
        val brand = view.getStringEtBrand()
        val model = view.getStringEtModel()
        val fuelList = view.getFuelList()
        val maitenanceList: List<Maitenance> = ArrayList()

        return Vehicle(brand, model, fuelList, maitenanceList)
    }

    private fun saveVehicle(vehicle: Vehicle) {

    }

    private fun editVehicle(vehicle: Vehicle) {

    }

    override fun addFuel() {
        val fuel = buildFuel()

        if(! validateFuel(fuel))
            return

        view.addFuel(fuel)
    }

    private fun buildFuel(): Fuel {
        val type = view.getStringSpinnerFuelType()
        val kml = view.getDoubleEtFuelKml()

        return Fuel(type, kml)
    }

    private fun validateFuel(fuel: Fuel): Boolean {
        var error = 0

        if(fuel.type == context.getString(R.string.select)) {
            view.setErrorSpinnerFuelType(context.getString(R.string.select_fuel))
            error++
        }

        if(fuel.kml == 0.0) {
            view.setErrorEtFuelKml(context.getString(R.string.required_field))
            error++
        }

        return error == 0
    }
}