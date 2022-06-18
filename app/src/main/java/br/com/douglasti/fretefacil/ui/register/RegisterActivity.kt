package br.com.douglasti.fretefacil.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.douglasti.fretefacil.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private val bind by lazy { ActivityRegisterBinding.inflate(layoutInflater) }
    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)

        initView()
    }

    private fun initView() {

    }
}