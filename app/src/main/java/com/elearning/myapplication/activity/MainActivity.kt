package com.elearning.myapplication.activity

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.android.volley.RequestQueue
import com.elearning.myapplication.R
import com.elearning.myapplication.adapter.CharacterAdapter
import com.elearning.myapplication.model.CharacterModel
import com.elearning.myapplication.viewModel.CharacterViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    //declaring view model
    private val viewModel = ViewModelProvider.NewInstanceFactory().create(CharacterViewModel::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //call api from view model
        viewModel.characterApi(context = this@MainActivity)

        observeResponse()
    }
    //observing data from api
    private fun observeResponse() {
        viewModel.followersList.observe(this, {
            setAdapter(it)
        })
    }

// setting adapter view
    private fun setAdapter(list: Array<CharacterModel>) {
        mainRv.adapter = CharacterAdapter(list, this@MainActivity)
        mainRv.layoutManager = GridLayoutManager(this, 2)
    }
}