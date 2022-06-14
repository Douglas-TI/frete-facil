package br.com.douglasti.fretefacil.utils

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    companion object {
        private var user: String = ""

        fun setUser(user: String) {
            Companion.user = user
        }

        fun getUser(): String {
            return user
        }
    }
}