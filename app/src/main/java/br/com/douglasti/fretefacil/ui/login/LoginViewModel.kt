package br.com.douglasti.fretefacil.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    private val nome: MutableLiveData<String> = MutableLiveData("")

    fun getNome(): MutableLiveData<String> {
        return nome
    }

    fun setNome(nome: String) {
        this.nome.value = nome
        //value se chamado da main
        //postvalue se chamado de uma thread
    }
}