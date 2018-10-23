package com.xrc.kotlinproject.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import com.xrc.kotlinproject.custom.MultiStateView

/**
 * BaseActivity
 * Created by xrc on 18/10/15.
 */
abstract class BaseActivity : AppCompatActivity(), IBaseView, MultiStateView.OnRetryListener {

    private var mDialog: ProgressDialog? = null
    private var mRootView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRootView = layoutInflater.inflate(getLayoutId(), null, false)
        setContentView(mRootView)
        baseInit()
        init()
    }

    private fun baseInit() {
        val view = findMultiStateView(mRootView)
        if (view != null && view is MultiStateView) {
            view.listener = this
        }
    }

    abstract fun getLayoutId(): Int

    abstract fun init()

    override fun showDialog() {
        if (mDialog == null) {
            mDialog = ProgressDialog(this)
        }
        mDialog?.setMessage("加载中...")
        mDialog?.show()
    }

    override fun dismissDialog() {
        mDialog?.dismiss()
    }

    override fun onRetry() {

    }

    private fun findMultiStateView(view: View?): ViewGroup? {
        if (view is ViewGroup) {
            if (view is MultiStateView) {
                return view
            }
            for (i in 0 until view.childCount) {
                val child = view.getChildAt(i)
                if (child is ViewGroup) {
                    if (child is MultiStateView) {
                        return child
                    } else {
                        val multiStateView = findMultiStateView(child)
                        if (multiStateView != null) {
                            return multiStateView
                        }
                    }
                }

            }
        }
        return null
    }


}