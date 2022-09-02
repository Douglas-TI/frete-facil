package br.com.douglasti.fretefacil.ui.register

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.databinding.ActivityRegisterBinding
import br.com.douglasti.fretefacil.ui.base.BaseAppCompactActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : BaseAppCompactActivity() {

    private val bind by lazy { ActivityRegisterBinding.inflate(layoutInflater) }
    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)
        buildProgressBarDefaultCl(bind.root)


        initView()
    }

    private fun initView() {
        handleState()
        handleEvents()

        setBtRegister()
    }

    private fun handleState() = collectLatestLifecycleFlow(viewModel.registerState) {
        handleEtUser(it)
        handleEtPassword(it)
        handleEtPasswordConfirmation(it)
        handleLoading(it)
    }

    private fun handleEtUser(state: RegisterUiState) {
        if (state.userRequiredErrorMsg != null) {
            bind.etUsername.error = state.userRequiredErrorMsg.asString(this)
            bind.etUsername.requestFocus()
        }
        else
            bind.etUsername.error = null
    }

    private fun handleEtPassword(state: RegisterUiState) {
        if (state.passwordRequiredErrorMsg != null) {
            bind.etPassword.error = state.passwordRequiredErrorMsg.asString(this)
            bind.etPassword.requestFocus()
        }
        else
            bind.etPassword.error = null
    }

    private fun handleEtPasswordConfirmation(state: RegisterUiState) {
        if (state.passwordConfirmationRequiredErrorMsg != null) {
            bind.etPasswordConfirmation.error = state.passwordConfirmationRequiredErrorMsg.asString(this)
            bind.etPasswordConfirmation.requestFocus()
        }
        else
            bind.etPasswordConfirmation.error = null

        if (state.passwordConfirmationDifferentErrorMsg != null) {
            bind.etPasswordConfirmation.error = state.passwordConfirmationDifferentErrorMsg.asString(this)
            bind.etPasswordConfirmation.requestFocus()
        }
        else
            bind.etPasswordConfirmation.error = null
    }

    private fun handleLoading(state: RegisterUiState) {
        if(state.loading)
            setProgressBarVisibility(View.VISIBLE)
        else
            setProgressBarVisibility(View.INVISIBLE)
    }

    private fun handleEvents() = collectLatestLifecycleFlow(viewModel.registerEvent) {
        when(it) {
            is RegisterUiEvent.RegisterSuccessful -> {
                showToast(it.msg!!.asString(this))
                finish()
            }
        }
    }

    private fun setBtRegister() = bind.btRegister.setOnClickListener {
        viewModel.register(
            getStringEtUser(),
            getStringEtPassword(),
            getStringEtConfirmPassword()
        )
    }

    private fun getStringEtUser() = bind.etUsername.text.toString()

    private fun getStringEtPassword() = bind.etPassword.text.toString()

    private fun getStringEtConfirmPassword() = bind.etPasswordConfirmation.text.toString()
}