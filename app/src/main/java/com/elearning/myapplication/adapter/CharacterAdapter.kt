package com.elearning.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elearning.myapplication.R
import com.elearning.myapplication.activity.MainActivity
import com.elearning.myapplication.databinding.LayoutMainBinding
import com.elearning.myapplication.model.CharacterModel

class CharacterAdapter(var list: Array<CharacterModel>, var mainActivity: MainActivity) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: LayoutMainBinding = DataBindingUtil.bind(itemView)!!


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.data=list[position]
       /* Glide.with(mainActivity)
            .load(list[position].img)
            .into(holder.binding.img)
        holder.binding.name.text=list[position].name
*/
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
