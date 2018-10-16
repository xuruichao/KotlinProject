package com.xrc.kotlinproject.base

import android.support.v7.widget.RecyclerView
import android.view.View

class BaseHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun getView(id: Int): View {
        return itemView.findViewById(id)
    }
}