package com.devdroid.ranchtracker.iu.utils

import android.content.Context
import android.widget.Toast
import com.devdroid.ranchtracker.RanchTrackerApp
import com.google.android.material.dialog.MaterialAlertDialogBuilder

object UtilsMessage {

    fun showAlertOk(titulo: String?, mensaje: String?, contexto: Context) {
        val builder = MaterialAlertDialogBuilder(contexto)
        builder.setMessage(mensaje)
            .setTitle(titulo)
            .setCancelable(false)
            .setPositiveButton("Aceptar") { dialog, _ -> dialog.cancel() }
        builder.create().show()
    }

    fun showToast(mensaje: String) {
        Toast.makeText(
            RanchTrackerApp.getAppContext(),
            mensaje,
            Toast.LENGTH_LONG
        ).show()
    }

}