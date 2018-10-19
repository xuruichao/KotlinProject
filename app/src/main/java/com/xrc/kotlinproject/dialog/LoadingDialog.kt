package com.xrc.kotlinproject.dialog

import android.os.Bundle
import com.xrc.kotlinproject.R
import com.xrc.kotlinproject.base.BaseDialog

/**
 * LoadingDialog
 * Created by xrc on 18/10/19.
 */
class LoadingDialog : BaseDialog() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mDialog.setCanceledOnTouchOutside(false)
    }

    companion object {
        fun newInstance(): LoadingDialog {
            return LoadingDialog()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.dialog_loading
    }

    override fun init(bundle: Bundle?) {

    }

    override fun useDirectValue() : Boolean {
        return true
    }
}