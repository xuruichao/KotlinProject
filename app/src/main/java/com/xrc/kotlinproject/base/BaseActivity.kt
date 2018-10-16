package com.xrc.kotlinproject.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * BaseActivity
 * Created by xrc on 18/10/15.
 */
abstract class BaseActivity<P : BasePresenter<*>> : AppCompatActivity(), IBaseView {

    protected var mPresenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        baseInit()
        init()
    }


    private fun baseInit() {
        mPresenter = initPresenter()
    }

    abstract fun getLayoutId(): Int

    abstract fun initPresenter(): P

    abstract fun init()

    override fun showDialog() {
        Toast.makeText(this, "对话框展示", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detach()
    }
}