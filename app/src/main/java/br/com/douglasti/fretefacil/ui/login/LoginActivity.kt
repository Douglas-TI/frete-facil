package br.com.douglasti.fretefacil.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import br.com.douglasti.fretefacil.databinding.ActivityLoginBinding
import br.com.douglasti.fretefacil.ui.menu.MenuActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity(), ILoginContract.View {

    private lateinit var bind: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    var usuario = ""

    @Suppress("ProtectedInFinal")
    @Inject
    protected lateinit var presenter: ILoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(bind.root)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]


        loadView()
    }

    private fun loadView() {
        viewModel.getNome().observe(this) {
            bind.etUsuario.setText(it)
        }

        //setBtEnter()
        //presenter.loadPresenter()

        bind.button.setOnClickListener {
            viewModel.setNome(bind.editTextTextPersonName.text.toString())
        }
    }

    private fun setBtEnter() {
        bind.btEnter.setOnClickListener {
            //presenter.setInitialData()
        }
    }

    override fun openMenuActivity() {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }

    override fun getStringEtUsuario() = bind.etUsuario.text.toString()

    override fun setErrorEtUsuario(error: String) { bind.etUsuario.error = error }
}