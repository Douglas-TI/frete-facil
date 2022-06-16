package br.com.douglasti.fretefacil.ui.login

import android.R
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.com.douglasti.fretefacil.databinding.ActivityLoginBinding
import br.com.douglasti.fretefacil.model.dto.LoginUiState
import br.com.douglasti.fretefacil.source.local.SharedPrefs
import br.com.douglasti.fretefacil.ui.base.BaseAppCompactActivity
import br.com.douglasti.fretefacil.ui.menu.MenuActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : BaseAppCompactActivity(), ILoginContract.View {

    private val bind by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)

        initView()
    }

    private fun initView() {
        SharedPrefs.initSharedPreferences(this)
        setBtEnter()

        viewModel.autoLogin()

        setEvents()
    }

    private fun setEvents() =
        lifecycleScope.launchWhenStarted {
                viewModel.uiFlow.collect {
                   when(it) {
                       is LoginUiState.Text -> {
                           showToast(it.uiText.asString(this@LoginActivity))
                       }
                       is LoginUiState.OpenMenu -> {
                           openMenuActivity()
                       }
                   }
                }
        }

    private fun setBtEnter() =
        bind.btEnter.setOnClickListener {
            viewModel.setInitialData(getStringEtUsuario())
        }

    override fun openMenuActivity() {
        startActivity(Intent(this, MenuActivity::class.java))
    }

    override fun getStringEtUsuario() = bind.etUsuario.text.toString()

    override fun setErrorEtUsuario(error: String) { bind.etUsuario.error = error }
}