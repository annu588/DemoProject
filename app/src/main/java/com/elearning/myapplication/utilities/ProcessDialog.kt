package com.elearning.myapplication.utilities

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.elearning.myapplication.R
import java.lang.Exception

class ProcessDialog {
    companion object {
    private var progressDialog: Dialog? = null

    fun start(context: Context) {
        if (!isShowing()) {
            if (!(context as Activity).isFinishing) {
                progressDialog = Dialog(context)
                progressDialog!!.setCancelable(false)
                progressDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                progressDialog!!.setContentView(R.layout.progress_dialoge)
                progressDialog!!.show()
            }
        }
    }




        fun dismiss() {
            try {
                if (progressDialog != null && progressDialog!!.isShowing) {
                    progressDialog!!.dismiss()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                progressDialog = null
            }
        }

        fun isShowing(): Boolean {
            return if (progressDialog != null) {
                progressDialog!!.isShowing
            } else {
                false
            }
        }
    }

}
