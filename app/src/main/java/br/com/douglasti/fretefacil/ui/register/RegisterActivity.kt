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
        setErrorEt(bind.etUsername, it.userRequiredErrorMsg?.asString(this))
        setErrorEt(bind.etPassword, it.passwordRequiredErrorMsg?.asString(this))

        when {
            it.passwordConfirmationRequiredErrorMsg != null ->
                setErrorEt(bind.etPasswordConfirmation, it.passwordConfirmationRequiredErrorMsg.asString(this))
            it.passwordConfirmationDifferentErrorMsg != null ->
                setErrorEt(bind.etPasswordConfirmation, it.passwordConfirmationDifferentErrorMsg.asString(this))
            else -> setErrorEt(bind.etPasswordConfirmation, null)
        }

        if(it.loading)
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