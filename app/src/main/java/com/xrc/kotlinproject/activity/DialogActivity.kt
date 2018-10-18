package com.xrc.kotlinproject.activity

import com.xrc.kotlinproject.R
import com.xrc.kotlinproject.base.BaseActivity
import com.xrc.kotlinproject.base.BaseDialog
import com.xrc.kotlinproject.dialog.NormalDialog
import com.xrc.kotlinproject.presenter.EmptyPresenter
import com.xrc.kotlinproject.view.IEmptyView

/**
 * DialogActivity
 * Created by xrc on 18/10/18.
 */
class DialogActivity : BaseActivity<EmptyPresenter>(), IEmptyView {
    override fun getLayoutId(): Int {
        return R.layout.activity_dialog
    }

    override fun initPresenter(): EmptyPresenter {
        return EmptyPresenter(this)
    }

    override fun init() {
        val dialog : NormalDialog = NormalDialog.newInstance()
        dialog.show(supportFragmentManager)
    }
}