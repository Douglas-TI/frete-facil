package br.com.douglasti.fretefacil.mvp.iface.contract

interface IMainContract {

    interface View {
        fun getStringEtUsuario(): String
        fun setErrorEtUsuario(error: String)
        fun openMenuActivity()

    }

    interface Presenter {
        fun loadPresenter()
        fun setInitialData()
    }
}