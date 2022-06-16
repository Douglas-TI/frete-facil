package br.com.douglasti.fretefacil.ui.login

interface ILoginContract {

    interface View {
        fun getStringEtUsuario(): String
        fun setErrorEtUsuario(error: String)
        fun openMenuActivity()

    }
}