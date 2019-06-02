package com.xrc.kotlinproject.base

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

@Suppress("UNCHECKED_CAST")
open class BaseHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var mViewContainer: Map<Int, View> = HashMap()

    fun <T : View> getView(id: Int): T {
        val view = mViewContainer[id]
        if (view != null) {
            return view as T
        }
        return itemView.findViewById(id)
    }

    fun setText(id: Int, content: CharSequence) {
        val tv: TextView = getView(id)
        tv.text = content
    }
}