package br.com.douglasti.fretefacil.ui.login

import android.content.Context
import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.source.local.SharedPreferences

import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class LoginPresenter @Inject constructor(@ActivityContext private val context: Context,
                                         @ApplicationContext private val appContext: Context): ILoginContract.Presenter {

    val view: ILoginContract.View = context as ILoginContract.View

    override fun loadPresenter() {
        SharedPreferences.initSharedPreferences(appContext)
        autoLogin()
    }

    private fun autoLogin() {
        if(SharedPreferences.getUser().isEmpty())
            return

        view.openMenuActivity()
    }

    override fun setInitialData() {
        if(view.getStringEtUsuario().isBlank()) {
            view.setErrorEtUsuario(context.getString(R.string.required_field))
            return
        }

        SharedPreferences.setUser(view.getStringEtUsuario())
        view.openMenuActivity()
    }
}