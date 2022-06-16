package br.com.douglasti.fretefacil.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.databinding.ActivityLoginBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

open class BaseAppCompactActivity: AppCompatActivity() {

    private lateinit var viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun setViewModel(viewModel: BaseViewModel) {
        this.viewModel = viewModel

        setToastViewModel()
    }

    fun setToastViewModel() {}
        /*lifecycleScope.launch {
            viewModel.errors.collect { error ->
                showToast(error.asString(getActivityContext()))
            }
        }*/

    fun showToast(text: String) = Toast.makeText(this, text, Toast.LENGTH_LONG).show()

    fun getDefaultSpinnerAdapter(array: Array<String>): ArrayAdapter<String> {
        val adapter = ArrayAdapter(this, R.layout.spinner, array)
        adapter.setDropDownViewResource(R.layout.spinner_dropdown)
        return adapter
    }
}