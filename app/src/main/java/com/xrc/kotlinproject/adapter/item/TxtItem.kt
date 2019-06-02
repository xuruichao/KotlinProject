package com.xrc.kotlinproject.adapter.item

import com.xrc.kotlinproject.R
import com.xrc.kotlinproject.base.BaseHolder
import com.xrc.kotlinproject.base.BaseItem
import com.xrc.kotlinproject.bean.TxtBean

/**
 * TxtItem
 * Created by xrc on 18/10/26.
 */
class TxtItem : BaseItem<TxtBean>() {
    override fun getTemplate(): String {
        return "txt"
    }

    override fun getLayoutId(): Int {
        return R.layout.item_list
    }

    override fun onBind(holder: BaseHolder, bean: TxtBean, position: Int) {
        with(holder) {
            setText(R.id.tv_content, "123")
        }
    }
}