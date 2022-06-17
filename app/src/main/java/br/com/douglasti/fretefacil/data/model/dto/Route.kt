package br.com.douglasti.fretefacil.data.model.dto

import android.app.Activity
import br.com.douglasti.fretefacil.ui.menu.MenuActivity

class Route(val activity: String) {

    fun getActivity(): Class<MenuActivity>? {
        return if(activity == "A")
            MenuActivity::class.java
        else
            null
    }


}