package br.com.douglasti.fretefacil.ui.menu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.douglasti.fretefacil.data.local.SharedPrefs
import br.com.douglasti.fretefacil.databinding.ActivityMenuBinding
import br.com.douglasti.fretefacil.ui.vehicle.manage.VehicleManageActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MenuActivity : AppCompatActivity(), IMenuContract.View {

    private lateinit var bind: ActivityMenuBinding

    @Inject lateinit var presenter: IMenuContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val id = intent.getStringExtra("st1")
        val name = intent.getIntExtra("st2", 0)

        loadView()
    }

    private fun loadView() {
        setOpenVehicleActivity()
        title = "Bem vindo " + SharedPrefs.getUser()
        setBtExit()
    }

    private fun setOpenVehicleActivity() {
        val intent = Intent(this, VehicleManageActivity::class.java)
        bind.btVehicle.setOnClickListener { startActivity(intent) }
    }

    private fun setBtExit() {
        bind.btExit.setOnClickListener {
            SharedPrefs.setUser("")
            finish()
        }
    }
}