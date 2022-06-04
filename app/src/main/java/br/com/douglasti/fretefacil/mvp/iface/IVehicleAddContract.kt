package br.com.douglasti.fretefacil.mvp.iface

import br.com.douglasti.fretefacil.mvp.model.entities.Fuel

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

        fun getStringEtMaitenanceCostMonths(): String
        fun setErrorEtMaitenanceCostMonths(error: String)

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