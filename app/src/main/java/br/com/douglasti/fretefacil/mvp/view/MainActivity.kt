package br.com.douglasti.fretefacil.mvp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.douglasti.fretefacil.databinding.ActivityMainBinding
import br.com.douglasti.fretefacil.mvp.iface.contract.IMainContract
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), IMainContract.View {

    private lateinit var bind: ActivityMainBinding

    @Suppress("ProtectedInFinal")
    @Inject
    protected lateinit var presenter: IMainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
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