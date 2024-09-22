package br.com.douglasti.fretefacil.ui.menu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.douglasti.fretefacil.data.local.SharedPrefs
import br.com.douglasti.fretefacil.databinding.ActivityMenuBinding
import br.com.douglasti.fretefacil.ui.login.LoginActivity
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

        loadView()
    }

    private fun loadView() {
        setOpenVehicleActivity()
        title = "Frete Fácil " //+ SharedPrefs.getUser()
        setBtLogin()
    }

    private fun setOpenVehicleActivity() {
        val intent = Intent(this, VehicleManageActivity::class.java)
        bind.btVehicle.setOnClickListener { startActivity(intent) }
    }

    private fun setBtLogin() {
        bind.btLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            bind.btLogin.setOnClickListener { startActivity(intent) }
        }
    }
}