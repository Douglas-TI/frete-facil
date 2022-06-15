package br.com.douglasti.fretefacil.ui.vehicle.add

import br.com.douglasti.fretefacil.model.entity.vehicle.Fuel

interface IVehicleAddContract {

    interface View {
        fun getStringEtBrand(): String
        fun setErrorEtBrand(error: String)

        fun getStringEtModel(): String
        fun setErrorEtModel(error: String)

        fun getStringSpinnerFuelType(): String
        fun setErrorSpinnerFuelType(error: String)

        fun setArraySpinnerFuelType(array: Array<String>)
        fun getDoubleEtFuelKml(): Double
        fun setErrorEtFuelKml(error: String)

        fun getStringEtMaitenanceCost(): String
        fun setErrorEtMaitenanceCost(error: String)

        fun getStringEtMaitenanceFrequency(): String
        fun setErrorEtMaitenanceFrequency(error: String)

        fun getFuelList(): MutableList<Fuel>
        fun addFuel(fuel: Fuel)

        fun setVisibilityFuelRequired(visibility: Int)

        fun getOperationType(): String?
    }

    interface  Presenter {
        fun load()

        fun confirmVehicle()
        fun addFuel()
    }

    interface Model {

    }
}