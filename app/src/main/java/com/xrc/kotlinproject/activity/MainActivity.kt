package com.xrc.kotlinproject.activity

import android.content.Intent
import android.view.View
import com.xrc.kotlinproject.R
import com.xrc.kotlinproject.base.BaseActivity
import com.xrc.kotlinproject.presenter.MainPresenter
import com.xrc.kotlinproject.view.IMainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>(), IMainView, View.OnClickListener {
    override fun onClick(v: View?) {
        val id = v?.id
        when (id) {
            R.id.btn1 -> {
                mPresenter?.login("123", "123")
            }
            R.id.btn2 -> {
                startActivity(Intent(this, ListActivity::class.java))
            }
            R.id.btn3 -> {
                startActivity(Intent(this, DialogActivity::class.java))
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun init() {
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
    }

    override fun loginSuccess() {

    }

    override fun loginError() {

    }

}
