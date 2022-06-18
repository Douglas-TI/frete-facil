package br.com.douglasti.fretefacil.ui.login

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.databinding.ActivityLoginBinding
import br.com.douglasti.fretefacil.data.local.SharedPrefs
import br.com.douglasti.fretefacil.ui.base.BaseAppCompactActivity
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

        //handleOneTimeEvents()
        handleUiState()
        handleEvents()
    }

    private fun handleUiState() = lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            viewModel.loginState.collect {
                if(it.userErrorMessage != null)
                    bind.etUsuario.setText(getString(R.string.login_required))
                if(it.userErrorMessage == null)
                    bind.etUsuario.setText("")
            }
        }
    }

    private fun handleEvents() {
        collectLatestLifecycleFlow(viewModel.loginEvent) {
            when(it) {
                is LoginUiEvent.loginSucessful -> openMenuActivity()
            }
        }
    }

    /*private fun handleOneTimeEvents() = collectLatestLifecycleFlow(viewModel.loginFlow) {
       when(it) {
           is LoginUiState.Text -> {
               showToast(it.uiText.asString(this@LoginActivity))
           }
           is LoginUiState.OpenMenu -> {
               openMenuActivity()
           }
       }
    }*/

    private fun setBtEnter() = bind.btEnter.setOnClickListener {
        viewModel.login(getStringEtUsuario())
        openMenuActivity()
    }

    override fun openMenuActivity() {
        /*val map: HashMap<String, Any> = hashMapOf("st1" to "obj1", "st2" to 2)
        val route = Route(MenuActivity::class.java, map)

        val intent = Intent(this, route.activityClass)
        setIntentExtras(route.extras, intent)
        startActivity(intent)*/
    }

    override fun getStringEtUsuario() = bind.etUsuario.text.toString()

    override fun setErrorEtUsuario(error: String) { bind.etUsuario.error = error }
}