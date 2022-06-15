package br.com.douglasti.fretefacil.ui.menu

import android.content.Intent
import android.os.Bundle
import br.com.douglasti.fretefacil.util.App
import br.com.douglasti.fretefacil.source.local.SharedPreferences
import br.com.douglasti.fretefacil.databinding.ActivityMenuBinding
import br.com.douglasti.fretefacil.ui.base.BaseAppCompactActivity
import br.com.douglasti.fretefacil.ui.vehicle.manage.VehicleManageActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MenuActivity : BaseAppCompactActivity(), IMenuContract.View {

    private lateinit var bind: ActivityMenuBinding

    @Suppress("ProtectedInFinal")
    @Inject protected lateinit var presenter: IMenuContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(bind.root)

        loadView()
    }

    private fun loadView() {
        setOpenVehicleActivity()
        title = "Bem vindo " + App.getUser()
        setBtExit()
    }

    private fun setOpenVehicleActivity() {
        val intent = Intent(this, VehicleManageActivity::class.java)
        bind.btVehicle.setOnClickListener { startActivity(intent) }
    }

    private fun setBtExit() {
        bind.btExit.setOnClickListener {
            SharedPreferences.setUser("")
            finish()
        }
    }
}