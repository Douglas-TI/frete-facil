package br.com.douglasti.fretefacil.ui.menu

import android.content.Context
import android.util.Log
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class MenuPresenter @Inject constructor(@ActivityContext private val context: Context): IMenuContract.Presenter {

    init {
        Log.i("FreteFacil", "teste")
    }
}