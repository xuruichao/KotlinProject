package com.xrc.kotlinproject.adapter

import android.widget.TextView
import com.xrc.kotlinproject.R
import com.xrc.kotlinproject.base.BaseAdapter
import com.xrc.kotlinproject.base.BaseHolder
import com.xrc.kotlinproject.bean.ListBean

class ListAdapter : BaseAdapter<ListBean>() {
    override fun getLayoutId(): Int {
        return R.layout.item_list
    }

    override fun onBind(holder: BaseHolder, bean: ListBean?, position: Int) {
        val tvContent: TextView = holder.getView(R.id.tv_content) as TextView
        tvContent.text = bean?.content
    }

}