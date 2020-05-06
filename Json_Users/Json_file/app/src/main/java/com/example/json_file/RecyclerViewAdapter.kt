package com.example.json_file

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.second_layout.view.*


class RecyclerViewAdapter(
    private val users: MutableList<UserModel.UserData>
) : RecyclerView.Adapter<ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind() {
            val model = users[adapterPosition]
            itemView.fNameTextView.text = model.firstName
            itemView.sNameTextView.text = model.lastName
            itemView.mailTextView.text = model.email
            Glide.with(itemView.context).load(model.avatar).into(itemView.userImage)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.second_layout,
                parent,
                false
            )
        )
    }


    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.onBind()
        }
    }
}


