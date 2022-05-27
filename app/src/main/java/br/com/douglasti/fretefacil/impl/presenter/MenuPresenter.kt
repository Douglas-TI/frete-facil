package br.com.douglasti.fretefacil.impl.presenter

import android.content.Context
import android.util.Log
import br.com.douglasti.fretefacil.iface.IMenuContract
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class MenuPresenter @Inject constructor(@ActivityContext private val context: Context): IMenuContract.Presenter {

    init {
        Log.i("FreteFacil", "teste")
    }
}