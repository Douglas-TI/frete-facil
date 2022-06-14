package br.com.douglasti.fretefacil.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.douglasti.fretefacil.databinding.ActivityLoginBinding
import br.com.douglasti.fretefacil.ui.menu.MenuActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity(), ILoginContract.View {

    private lateinit var bind: ActivityLoginBinding

    @Suppress("ProtectedInFinal")
    @Inject
    protected lateinit var presenter: ILoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(bind.root)

        loadView()
    }

    private fun loadView() {
        setBtEnter()
        presenter.loadPresenter()
    }

    private fun setBtEnter() {
        bind.btEnter.setOnClickListener {
            presenter.setInitialData()
        }
    }

    override fun openMenuActivity() {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }

    override fun getStringEtUsuario() = bind.etUsuario.text.toString()

    override fun setErrorEtUsuario(error: String) { bind.etUsuario.error = error }
}