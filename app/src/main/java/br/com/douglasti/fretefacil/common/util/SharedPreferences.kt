package br.com.douglasti.fretefacil.common.util

import android.content.Context
import androidx.preference.PreferenceManager

class SharedPreferences {

    companion object {

        private lateinit var sharedPreferences: android.content.SharedPreferences

        fun initSharedPreferences(context: Context) {
            sharedPreferences =  PreferenceManager.getDefaultSharedPreferences(context)
        }

        fun setUser(user: String) {
            val editor = sharedPreferences.edit()
            editor.putString("Name", user)
            editor.apply()
        }

        fun getUser(): String {
            return sharedPreferences.getString("Name", "")!!
        }
    }
}