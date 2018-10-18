package com.xrc.kotlinproject.base

import android.support.v7.widget.RecyclerView
import android.view.View

class BaseHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun <T : View> getView(id: Int): T {
        return itemView.findViewById(id)
    }
}