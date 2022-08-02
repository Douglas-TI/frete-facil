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

        initView()
    }

    private fun initView() {
        handleState()
        handleEvents()

        setBtRegister()
    }

    private fun handleState() = collectLatestLifecycleFlow(viewModel.registerState) {
        if (it.userRequiredErrorMsg != null) {
            val msg = it.emptyUserErrorMsg.asString(this@LoginActivity)
            bind.etUsername.error = msg
            bind.etUsername.requestFocus()
        } else
            bind.etUsername.error = null

        if(it.loading)
            setProgressBarVisibility(View.VISIBLE)
        else
            setProgressBarVisibility(View.INVISIBLE)
    }

    private fun handleEvents() = collectLatestLifecycleFlow(viewModel.registerEvent) {
        when(it) {
            is RegisterUiEvent.registerSuccessful -> {
                showToast(getString(R.string.registered_successfully))
                finishRegister()
            }
        }
    }

    private fun setBtRegister() =
        bind.btRegister.setOnClickListener {
            viewModel.register(
                getStringEtUser(),
                getStringEtPassword(),
                getStringEtConfirmPassword()
            )
        }

    private fun finishRegister() = finish()

    private fun getStringEtUser() = bind.etUsername.text.toString()

    private fun getStringEtPassword() = bind.etPassword.text.toString()

    private fun getStringEtConfirmPassword() = bind.etConfirmPassword.text.toString()
}