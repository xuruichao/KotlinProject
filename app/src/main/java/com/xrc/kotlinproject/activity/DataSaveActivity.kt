package com.xrc.kotlinproject.activity

import android.view.View
import com.xrc.kotlinproject.R
import com.xrc.kotlinproject.base.BaseActivity
import com.xrc.kotlinproject.util.Preference
import com.xrc.kotlinproject.util.ToastUtil
import com.xrc.kotlinproject.view.IEmptyView
import kotlinx.android.synthetic.main.activity_data_save.*

/**
 * DataSaveActivity
 * Created by xrc on 18/10/22.
 */
class DataSaveActivity : BaseActivity(), IEmptyView, View.OnClickListener {

    private var data: String? by Preference("data", "123")

    override fun onClick(v: View?) {
        val id = v?.id
        when (id) {
            R.id.save -> {
                ToastUtil.showToast(data!!)
                data = "456"
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_data_save
    }

    override fun init() {
        save.setOnClickListener(this)
    }
}