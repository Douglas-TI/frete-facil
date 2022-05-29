package br.com.douglasti.fretefacil.mvp.iface

interface IVehicleAddContract {

    interface View {
        fun getStringEtBrand(): String
        fun getStringEtModel(): String
        fun getStringEtKml(): String
        fun getStringEtMaitenanceCost(): String
        fun getStringEtMaitenanceCostMonths(): String
    }

    interface  Presenter {
        fun save()
    }

    interface Model {

    }
}