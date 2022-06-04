package br.com.douglasti.fretefacil.mvp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.douglasti.fretefacil.databinding.ActivityMenuBinding
import br.com.douglasti.fretefacil.mvp.iface.IMenuContract
import br.com.douglasti.fretefacil.mvp.view.vehicle.VehicleManageActivity
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

        setTitle("Bem vindo, Douglas.")
    }

    private fun setOpenVehicleActivity() {
        val intent = Intent(this, VehicleManageActivity::class.java)
        bind.btVehicle.setOnClickListener { startActivity(intent) }
    }
}