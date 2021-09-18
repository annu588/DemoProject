package com.elearning.myapplication.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elearning.myapplication.apiUtility.APIUtility
import com.elearning.myapplication.model.CharacterModel

class CharacterViewModel : ViewModel() {
    // creating list
    var followersList = MutableLiveData<Array<CharacterModel>>()


    fun characterApi(context: Context) {
//calling character api from server
        APIUtility(context).characterApi(context, true, object :
            APIUtility.APIResponseListener<Array<CharacterModel>> {
            override fun onReceiveResponse(response: Array<CharacterModel>) {
                followersList.postValue(response)
            }
        })
    }


}