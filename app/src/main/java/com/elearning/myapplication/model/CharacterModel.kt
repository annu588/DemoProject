package com.elearning.myapplication.model

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class CharacterModel {

    @SerializedName("char_id")
    @Expose
    val charId: Int? = null

    @SerializedName("name")
    @Expose
    val name: String? = null

    @SerializedName("birthday")
    @Expose
    val birthday: String? = null

    @SerializedName("occupation")
    @Expose
    val occupation: List<String>? = null

    @SerializedName("img")
    @Expose
    val img: String? = null

    @SerializedName("status")
    @Expose
    val status: String? = null

    @SerializedName("nickname")
    @Expose
    val nickname: String? = null

    @SerializedName("appearance")
    @Expose
    val appearance: List<Int>? = null

    @SerializedName("portrayed")
    @Expose
    val portrayed: String? = null

    @SerializedName("category")
    @Expose
    val category: String? = null

    @SerializedName("better_call_saul_appearance")
    @Expose
    val betterCallSaulAppearance: List<Any>? = null

    companion object {
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