package br.com.douglasti.fretefacil.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.databinding.ActivityLoginBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

open class BaseAppCompactActivity: AppCompatActivity() {

    private lateinit var viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun showToast(text: String) = Toast.makeText(this, text, Toast.LENGTH_LONG).show()

    fun getDefaultSpinnerAdapter(array: Array<String>): ArrayAdapter<String> {
        val adapter = ArrayAdapter(this, R.layout.spinner, array)
        adapter.setDropDownViewResource(R.layout.spinner_dropdown)
        return adapter
    }

    fun <T> collectLatestLifecycleFlow(flow: Flow<T>, collect: suspend (T) -> Unit) =
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                flow.collectLatest(collect)
            }
        }
}