package br.com.douglasti.fretefacil.mvp.presenter

import android.content.Context
import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.common.util.App
import br.com.douglasti.fretefacil.common.util.SharedPreferences

import br.com.douglasti.fretefacil.mvp.iface.contract.IMainContract
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class MainPresenter @Inject constructor(@ActivityContext private val context: Context,
                                        @ApplicationContext private val appContext: Context): IMainContract.Presenter {

    val view: IMainContract.View = context as IMainContract.View

    override fun loadPresenter() {
        SharedPreferences.initSharedPreferences(appContext)
        autoLogin()
    }

    private fun autoLogin() {
        if(SharedPreferences.getUser().isEmpty())
            return

        App.setUser(SharedPreferences.getUser())
        view.openMenuActivity()
    }

    override fun setInitialData() {
        if(view.getStringEtUsuario().isBlank()) {
            view.setErrorEtUsuario(context.getString(R.string.required_field))
            return
        }

        SharedPreferences.setUser(view.getStringEtUsuario())

        App.setUser(SharedPreferences.getUser())
        view.openMenuActivity()
    }
}