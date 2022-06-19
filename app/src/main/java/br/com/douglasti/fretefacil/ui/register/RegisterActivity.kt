package br.com.douglasti.fretefacil.ui.register

import android.os.Bundle
import androidx.activity.viewModels
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

        bind.btRegister.setOnClickListener { openMenuActivity() }
    }

    private fun handleState() = collectLatestLifecycleFlow(viewModel.registerState) {

    }

    private fun handleEvents() = collectLatestLifecycleFlow(viewModel.registerEvent) {
        when(it) {

        }
    }

    private fun openMenuActivity() {
        finish()
    }
}