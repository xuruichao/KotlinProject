package com.xrc.kotlinproject.base

import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseAdapter<in T> : Adapter<BaseHolder>() {

    private var mList: List<T>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        return BaseHolder(LayoutInflater.from(ProjectApplication.instance()).inflate(getLayoutId(), parent, false))
    }

    override fun getItemCount(): Int {
        return if (mList == null) {
            0
        } else {
            mList?.size!!
        }
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        onBind(holder, mList?.get(position), position)
    }

    abstract fun getLayoutId(): Int

    abstract fun onBind(holder: BaseHolder, bean: T?, position: Int)


    fun updateData(list : List<T>) {
        mList = list
    }
}