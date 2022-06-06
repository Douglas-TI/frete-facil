package br.com.douglasti.fretefacil.common.util

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    companion object {
        private var user: String = ""

        fun setUser(user: String) {
            this.user = user
        }

        fun getUser(): String {
            return this.user
        }
    }
}