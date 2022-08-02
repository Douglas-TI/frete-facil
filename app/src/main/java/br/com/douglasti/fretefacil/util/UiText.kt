package br.com.douglasti.fretefacil.util

import android.content.Context

sealed class UiText {

    data class DynamicString(val value: String): UiText()
    class StringRes(@androidx.annotation.StringRes val resId: Int, vararg val args: Any): UiText()

    fun asResource(): Int {
        return when(this) {
            is StringRes -> resId
            else -> { 0 }
        }
    }

    fun asString(context: Context): String {
        return when(this) {
            is DynamicString -> value
            is StringRes -> context.getString(resId, *args)
        }
    }
}
