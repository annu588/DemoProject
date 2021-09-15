package com.elearning.myapplication.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elearning.myapplication.model.CharacterModel
import com.elearning.myapplication.apiUtility.APIUtility
import com.google.gson.Gson

class CharacterViewModel : ViewModel() {
    var followersList = MutableLiveData<Array<CharacterModel>>()


    fun characterApi(context: Context) {

        APIUtility(context).characterApi(context, true, object :
            APIUtility.APIResponseListener<Array<CharacterModel>> {
            override fun onReceiveResponse(response: Array<CharacterModel>) {
                Log.e("TAG", "onReceiveResponse: "+Gson().toJson(response) )
               followersList.postValue(response)
            }
      /*  APIUtility(context).characterApi(context,true,)*/


        })
    }


}