package com.xrc.kotlinproject.base

import android.view.LayoutInflater
import android.view.ViewGroup
import com.xrc.kotlinproject.bean.BaseMultiTypeBean

/**
 * MultiTypeAdapter
 * Created by xrc on 18/10/25.
 */
abstract class MultiTypeAdapter : BaseAdapter<BaseMultiTypeBean>() {

    private lateinit var mItems: MutableList<BaseItem<*>>

    override fun getLayoutId(): Int {
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val item = mItems[viewType]
        return BaseHolder(LayoutInflater.from(ProjectApplication.instance()).inflate(item.getLayoutId(),
                parent, false))
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        onBind(holder, mList[position], position)
    }

    override fun getItemViewType(position: Int): Int {
        val bean = mList[position]
        for ((index, value) in mItems.withIndex()) {
            if (value.getTemplate() == bean.template) {
                return index
            }
        }
        return super.getItemViewType(position)
    }

    fun addItem(item: BaseItem<*>): MultiTypeAdapter {
        mItems.add(item)
        return this
    }
}