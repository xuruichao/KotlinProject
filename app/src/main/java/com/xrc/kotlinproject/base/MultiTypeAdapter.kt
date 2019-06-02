package com.xrc.kotlinproject.base

import android.view.LayoutInflater
import android.view.ViewGroup
import com.xrc.kotlinproject.bean.BaseMultiTypeBean

/**
 * MultiTypeAdapter
 * Created by xrc on 18/10/25.
 */
abstract class MultiTypeAdapter : BaseAdapter<BaseMultiTypeBean>() {

    private var mItems: MutableList<*>

    init {
        mItems = initItems()
    }

    abstract fun initItems(): MutableList<*>

    override fun getLayoutId(): Int {
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val item = mItems[viewType]
        if (item is BaseItem<*>)
            return BaseHolder(LayoutInflater.from(ProjectApplication.instance()).inflate(item.getLayoutId(),
                    parent, false))
        return BaseHolder(LayoutInflater.from(ProjectApplication.instance()).inflate(0,
                parent, false))
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        val bean = mList[position]
        for (value in mItems) {
            if (value is BaseItem<*>) {
                if (value.getTemplate() == bean.template) {
                    //value.onBind(holder, bean, position)
                    return
                }
            }
        }
    }

    override fun onBind(holder: BaseHolder, bean: BaseMultiTypeBean, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemViewType(position: Int): Int {
        val bean = mList[position]
        for ((index, value) in mItems.withIndex()) {
            if (value is BaseItem<*>) {
                if (value.getTemplate() == bean.template) {
                    return index
                }
            }
        }
        return super.getItemViewType(position)
    }

}