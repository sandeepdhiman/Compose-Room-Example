package com.example.mycomposeapp

import android.app.Activity
import android.content.Context
import android.util.Patterns
import android.view.View
import android.view.inputmethod.InputMethodManager

class Util {
    companion object{
        fun isValidEmail(target: CharSequence?): Boolean {
            return if (target == null) {
                false
            } else {
                Patterns.EMAIL_ADDRESS.matcher(target).matches()
            }
        }

        fun isValidPhoneNumber(target: CharSequence): Boolean {
            return if (target.length != 10) {
                false
            } else {
                Patterns.PHONE.matcher(target).matches()
            }
        }

        fun hideSoftKeyBoard(context: Context, view: View) {
            try {
                val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm?.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
            } catch (e: Exception) {
                // TODO: handle exception
                e.printStackTrace()
            }

        }
    }
}