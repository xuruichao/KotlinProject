package com.xrc.kotlinproject.activity

import android.view.View
import com.xrc.kotlinproject.R
import com.xrc.kotlinproject.base.BaseActivity
import com.xrc.kotlinproject.dialog.LoadingDialog
import com.xrc.kotlinproject.dialog.NormalDialog
import com.xrc.kotlinproject.view.IEmptyView
import kotlinx.android.synthetic.main.activity_main.*

/**
 * DialogActivity
 * Created by xrc on 18/10/18.
 */
class DialogActivity : BaseActivity(), IEmptyView, View.OnClickListener {
    override fun onClick(v: View?) {
        val id = v?.id
        when (id) {
            R.id.btn1 -> {
                val dialog = NormalDialog.newInstance("文字显示区域")
                dialog.show(supportFragmentManager)
            }
            R.id.btn2 -> {
                val dialog = LoadingDialog.newInstance()
                dialog.show(supportFragmentManager)
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_dialog
    }

    override fun init() {
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
    }
}