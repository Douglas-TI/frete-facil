package br.com.douglasti.fretefacil.data.model.dto

import android.app.Activity
import android.util.Log
import br.com.douglasti.fretefacil.ui.login.LoginActivity
import br.com.douglasti.fretefacil.ui.menu.MenuActivity

data class Route <T> (val activityClass: Class<T>, val extras: HashMap<String, Any>)