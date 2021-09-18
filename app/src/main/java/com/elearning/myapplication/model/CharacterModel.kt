package com.elearning.myapplication.model

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


data class CharacterModel(
    val charId: Int? = null,
    val name: String? = null,
    val birthday: String? = null,
    val occupation: List<String>? = null,
    val img: String? = null,
    val status: String? = null,
    val nickname: String? = null,
    val appearance: List<Int>? = null,
    val portrayed: String? = null
) {

    companion object {

        //set image
        @JvmStatic
        @BindingAdapter("android:profileImage")
        fun loadImage(view: View?, url: String?) {
            val imageView = view as ImageView?
            Glide.with(view!!)
                .load(url)
                .into(imageView!!)
        }
    }
}