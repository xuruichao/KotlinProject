package com.xrc.kotlinproject.activity

import com.xrc.kotlinproject.R
import com.xrc.kotlinproject.adapter.ListAdapter
import com.xrc.kotlinproject.base.BaseActivity
import com.xrc.kotlinproject.bean.ListBean
import com.xrc.kotlinproject.presenter.ListContract
import com.xrc.kotlinproject.presenter.ListPresenter
import kotlinx.android.synthetic.main.activity_list.*

/**
 * ListActivity
 * Created by xrc on 18/10/16.
 */
class ListActivity : BaseActivity(), ListContract.View {

    private val mPresenter: ListPresenter by lazy { ListPresenter(this) }

    override fun empty() {
        multi_state_view.empty()
    }

    override fun success() {
        multi_state_view.normal()
        val adapter = ListAdapter()
        val data = getData()
        recycler_view.adapter = adapter
        adapter.updateData(data)
    }

    private fun getData(): List<ListBean> {
        val array: List<ListBean> = mutableListOf()
        for (i in 1..10) {
            val bean = ListBean()
            bean.content = "第$i"
            (array as MutableList).add(bean)
        }
        return array
    }

    override fun failed() {
        multi_state_view.error()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_list
    }

    override fun init() {
        mPresenter.requestInfo()
    }

    override fun onRetry() {
        mPresenter.requestInfo()
    }
}