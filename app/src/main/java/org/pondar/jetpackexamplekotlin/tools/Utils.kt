package org.pondar.jetpackexamplekotlin.tools

import android.app.Application
import android.content.Context
import android.view.Gravity
import android.widget.Toast
import org.pondar.jetpackexamplekotlin.R

//Utility class - singleton
object Utils {

    fun validate(vararg inputs: String, context:Context,showWarning: Boolean = true): Boolean {
        for (input in inputs) {
            if (input.isEmpty()) {
                if (showWarning) {
                    val toast = Toast.makeText(
                        context,
                        R.string.input_fields_empty,
                        Toast.LENGTH_LONG
                    )
                    toast.setGravity(Gravity.CENTER,0,0)
                    toast.show()
                }
                return false
            }
        }

        return true
    }
}