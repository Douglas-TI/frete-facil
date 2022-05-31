package br.com.douglasti.fretefacil.mvp.iface

interface IVehicleAddContract {

    interface View {
        fun getStringEtBrand(): String
        fun setErrorEtBrand(error: String)

        fun getStringEtModel(): String
        fun setErrorEtModel(error: String)

        fun getStringEtKml(): String
        fun setErrorEtKml(error: String)

        fun getStringEtMaitenanceCost(): String
        fun setErrorEtMaitenanceCost(error: String)

        fun getStringEtMaitenanceCostMonths(): String
        fun setErrorEtMaitenanceCostMonths(error: String)
    }

    interface  Presenter {
        fun validateSave()
    }

    interface Model {

    }
}