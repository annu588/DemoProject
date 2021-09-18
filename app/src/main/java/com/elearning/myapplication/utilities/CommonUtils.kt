package com.elearning.myapplication.utilities

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.elearning.myapplication.R
import com.gdacciaro.iOSDialog.iOSDialogBuilder

class CommonUtils {
    companion object{
        //checking whether network is available or not
        fun isNetworkAvailable(mContext: Context): Boolean {
            /* getting systems Service connectivity manager */
            val mConnectivityManager = mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val mNetworkInfos = mConnectivityManager.allNetworkInfo
            for (mNetworkInfo in mNetworkInfos) {
                if (mNetworkInfo.state == NetworkInfo.State.CONNECTED) {
                    return true
                }
            }
            return false
        }
// dialog to display there is no internet connection
        fun displayNetworkAlert(context: Context,  isFinish: Boolean) {
            iOSDialogBuilder(context)
                .setTitle("Network Error")
                .setSubtitle("Please Check Your Internet Connection and Try Again")
                .setBoldPositiveLabel(true)
                .setCancelable(true)
                .setPositiveListener(context.resources.getString(R.string.ok)) { dialog ->
                    if (isFinish) {
                        dialog.dismiss()
                        (context as Activity).finish()
                    } else {
                        dialog.dismiss()
                    }
                }.build().show()
        }




    }

}
