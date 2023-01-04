package br.com.douglasti.fretefacil.ui.base

import android.content.Context
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.com.douglasti.fretefacil.R
import br.com.douglasti.fretefacil.util.UiText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

fun Context.showToast(text: String) = Toast.makeText(this, text, Toast.LENGTH_LONG).show()

fun Context.getDefaultSpinnerAdapter(array: Array<String>): ArrayAdapter<String> {
    val adapter = ArrayAdapter(this, R.layout.spinner, array)
    adapter.setDropDownViewResource(R.layout.spinner_dropdown)
    return adapter
}

fun <T> LifecycleOwner.collectLatestLifecycleFlow(flow: Flow<T>, collect: suspend (T) -> Unit) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collectLatest(collect)
        }
    }
}

fun Context.buildProgressBarDefaultCl(layout: ConstraintLayout): ProgressBar {
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

    return progressBar
}

fun Context.setErrorEt(et: EditText, error: UiText?) {
    if(error == null) {
        et.error = null
    }
    else
    {
        et.error = error.asString(this)
        et.requestFocus()
    }
}

fun Context.showAlert(message: String, title: String? = null, icon: Int? = null) {
    val alert = AlertDialog.Builder(this)
        .setMessage(message)
        .setNeutralButton("OK", null)

    if(icon != null)
        alert.setIcon(icon)

    if(title != null)
        alert.setTitle(title)

    alert.show()
}