package com.xrc.kotlinproject.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.xrc.kotlinproject.custom.MultiStateView

/**
 * BaseActivity
 * Created by xrc on 18/10/15.
 */
abstract class BaseActivity<P : BasePresenter<*>> : AppCompatActivity(), IBaseView, MultiStateView.OnRetryListener {

    protected var mPresenter: P? = null
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
        mPresenter = initPresenter()
        val view = mPresenter?.findMultiStateView(mRootView)
        if (view != null && view is MultiStateView) {
            view.listener = this
        }
    }

    abstract fun getLayoutId(): Int

    abstract fun initPresenter(): P

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

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detach()
    }

    override fun onRetry() {

    }
}