package br.com.douglasti.fretefacil.mvp.view

import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.com.douglasti.fretefacil.R

open class BaseAppCompactActivity: AppCompatActivity() {

    fun getDefaultSpinnerAdapter(array: Array<String>): ArrayAdapter<String> {
        val adapter = ArrayAdapter(this, R.layout.spinner, array)
        adapter.setDropDownViewResource(R.layout.spinner_dropdown)
        return adapter
    }
}