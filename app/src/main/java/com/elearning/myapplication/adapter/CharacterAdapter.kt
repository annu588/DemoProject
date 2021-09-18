package com.elearning.myapplication.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.elearning.myapplication.R
import com.elearning.myapplication.activity.MainActivity
import com.elearning.myapplication.databinding.LayoutMainBinding
import com.elearning.myapplication.model.CharacterModel


class CharacterAdapter(val list: Array<CharacterModel>, var mainActivity: MainActivity) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // initializing data binding with view
        var binding: LayoutMainBinding = DataBindingUtil.bind(itemView)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //binding view the data using data binding
        holder.binding.data = list[position]
        //callingVisibiltyMethod
        setVisibilityOfView(holder)

    }

    // apply listener for visibility of name layout
    @SuppressLint("ClickableViewAccessibility")
    private fun setVisibilityOfView(holder: ViewHolder) {
        //detecting long press event and showing view
        holder.binding.img.setOnLongClickListener {
            holder.binding.nameLL.visibility = VISIBLE
            true
        }
        //detecting releasing touch event and hiding view
        holder.binding.img.setOnTouchListener { view, motionEvent ->
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                holder.binding.nameLL.visibility = GONE
            }
            false
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}
