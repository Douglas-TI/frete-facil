package br.com.douglasti.fretefacil.impl.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.douglasti.fretefacil.databinding.ActivityMenuBinding
import br.com.douglasti.fretefacil.iface.IMenuContract
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MenuActivity : AppCompatActivity(), IMenuContract.View {

    private lateinit var bind: ActivityMenuBinding

    @Suppress("ProtectedInFinal")
    @Inject protected lateinit var presenter: IMenuContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(bind.root)
    }

    @Suppress("UNUSED_PARAMETER")
    fun openVehicleActivity(view: View) =
        startActivity(Intent(this, VehicleActivity::class.java))
}