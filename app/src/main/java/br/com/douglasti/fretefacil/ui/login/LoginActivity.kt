package br.com.douglasti.fretefacil.ui.login

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import br.com.douglasti.fretefacil.databinding.ActivityLoginBinding
import br.com.douglasti.fretefacil.source.local.SharedPrefs
import br.com.douglasti.fretefacil.ui.base.BaseAppCompactActivity
import br.com.douglasti.fretefacil.ui.menu.MenuActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseAppCompactActivity(), ILoginContract.View {

    private val bind by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)
        setViewModel(viewModel)

        loadView()
    }

    private fun loadView() {
        SharedPrefs.initSharedPreferences(this)
        setBtEnter()

        viewModel.autoLogin()
    }

    private fun setBtEnter() =
        bind.btEnter.setOnClickListener {
            viewModel.setInitialData(getStringEtUsuario())
        }

    override fun openMenuActivity() =
        startActivity(Intent(this, MenuActivity::class.java))

    override fun getStringEtUsuario() = bind.etUsuario.text.toString()

    override fun setErrorEtUsuario(error: String) { bind.etUsuario.error = error }
}