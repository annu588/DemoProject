package com.elearning.myapplication.apiUtility

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.elearning.myapplication.model.CharacterModel
import com.elearning.myapplication.retrofit.ApiServices
import com.elearning.myapplication.retrofit.RetrofitInstance
import com.elearning.myapplication.utilities.CommonUtils
import com.elearning.myapplication.utilities.ProcessDialog
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class APIUtility(val context: Context) {

    val TAG = "APIUTILITY"
    open fun characterApi(
        context: Context,
        dialog: Boolean,
        listener: APIResponseListener<Array<CharacterModel>>
    ) {
        showDialog(context, dialog)
        networkCheck(context)
        val apiServices: ApiServices =
            RetrofitInstance(context).getInstance().create(ApiServices::class.java)
        val call: Call<Array<CharacterModel>> = apiServices.characterAPI()
        call.enqueue(object : Callback<Array<CharacterModel>?> {
            override fun onResponse(
                call: Call<Array<CharacterModel>?>,
                response: Response<Array<CharacterModel>?>
            ) {
                if (response.body() != null) {
                    Log.e(TAG, "onResponse: " + Gson().toJson(response.body()))
                    listener.onReceiveResponse(response.body()!!)
                } else {
                    showToast(context, response.message())
                    Log.e(TAG, "onResponse: " + response.message() + "--code" + response.code())
                }
                dismissDialog(dialog)
            }

            override fun onFailure(call: Call<Array<CharacterModel>?>, t: Throwable) {
                //listener.onResponseFailed()
                dismissDialog(dialog)
                Log.e(TAG, "onFailure: " + t.localizedMessage)
            }
        })
    }

    //listeners
    interface APIResponseListener<T> {
        fun onReceiveResponse(response: T)
        // fun onResponseFailed();
        //fun onStatusFalse(response: T);
    }

    //network check
    private fun networkCheck(context: Context) {
        if (!CommonUtils.isNetworkAvailable(context)) {
            CommonUtils.displayNetworkAlert(context, false)
            return
        }
    }

    // show dialog
    fun showDialog(context: Context?, isDialog: Boolean) {
        if (isDialog) {
            if (context != null) {
                ProcessDialog.start(context)
            }
        }
    }

    fun dismissDialog(isDialog: Boolean) {
        if (isDialog) {
            ProcessDialog.dismiss()
        }
    }

    //show toast
    fun showToast(context: Context, message: String) {
        Toast.makeText(
            context,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

}



