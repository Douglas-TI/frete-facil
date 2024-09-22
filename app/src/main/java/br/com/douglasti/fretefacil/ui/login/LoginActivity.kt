package br.com.douglasti.fretefacil.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.douglasti.fretefacil.data.local.SharedPrefs
import br.com.douglasti.fretefacil.databinding.ActivityLoginBinding
import br.com.douglasti.fretefacil.ui.base.*
import br.com.douglasti.fretefacil.ui.menu.MenuActivity
import br.com.douglasti.fretefacil.ui.register.RegisterActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val bind by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private val viewModel: LoginViewModel by viewModels()
    private val progressBar by lazy { buildProgressBarDefaultCl(bind.root) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)

        //initView()
    }

    private fun initView() {
        SharedPrefs.initSharedPreferences(this)

        setBtEnter()
        setBtNewUser()

        viewModel.autoLogin()

        handleState()
        handleEvents()
    }

    private fun handleState() = collectLatestLifecycleFlow(viewModel.uiState) {
        setErrorEt(bind.etUsername, it.etUsernameError)
        setErrorEt(bind.etPassword, it.etPasswordError)
        progressBar.visibility = it.loading
    }

    private fun handleEvents() = collectLatestLifecycleFlow(viewModel.uiEvent) {
        when(it) {
            is LoginUiEvent.ShowToast -> showToast(it.text.asString(this))
            is LoginUiEvent.ShowAlert -> showAlert(it.text.asString(this))
            is LoginUiEvent.OpenMenu -> openMenuActivity()
        }
    }

    private fun setBtEnter() = bind.btEnter.setOnClickListener {
        viewModel.login(getStringEtUser(), getStringEtPassword())
    }

    private fun setBtNewUser() = bind.btNewUser.setOnClickListener {
        openRegisterActivity()
    }

    private fun openMenuActivity() {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }

    private fun openRegisterActivity() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun getStringEtUser() = bind.etUsername.text.toString()

    private fun getStringEtPassword() = bind.etPassword.text.toString()
}