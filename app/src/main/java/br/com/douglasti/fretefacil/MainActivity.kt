package br.com.douglasti.fretefacil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.douglasti.fretefacil.databinding.ActivityMainBinding
import br.com.douglasti.fretefacil.mvp.view.MenuActivity

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        loadView()
    }

    private fun loadView() {
        setOpenMenuActivity()
    }

    private fun setOpenMenuActivity() {
        val intent = Intent(this, MenuActivity::class.java)
        bind.button.setOnClickListener { startActivity(intent) }
    }
}