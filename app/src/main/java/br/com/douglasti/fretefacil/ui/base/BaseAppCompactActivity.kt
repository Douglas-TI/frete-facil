package br.com.douglasti.fretefacil.ui.base

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.com.douglasti.fretefacil.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


open class BaseAppCompactActivity: AppCompatActivity() {

    private lateinit var progressBar: ProgressBar

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

    open fun buildProgressBarDefaultCl(layout: ConstraintLayout) {
        val progressBar = ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal)
        progressBar.isIndeterminate = true
        progressBar.visibility = View.INVISIBLE
        val params = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        params.startToStart = ConstraintSet.PARENT_ID
        params.endToEnd = ConstraintSet.PARENT_ID
        params.topToTop = ConstraintSet.PARENT_ID
        layout.addView(progressBar, params)
        this.progressBar = progressBar
    }

    open fun setProgressBarVisibility(visibility: Int) {
        runOnUiThread { progressBar.visibility = visibility }
    }
}