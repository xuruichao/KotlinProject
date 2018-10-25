package com.xrc.kotlinproject.util

import android.annotation.SuppressLint
import android.widget.Toast
import com.xrc.kotlinproject.base.ProjectApplication

@SuppressLint("ShowToast")
/**
 * ToastUtil
 * Created by xrc on 18/10/16.
 */
object ToastUtil {

    private val mToast: Toast by lazy {
        Toast.makeText(ProjectApplication.instance(), null, Toast.LENGTH_SHORT)
    }

    fun showToast(text: CharSequence) {
        mToast.setText(text)
        mToast.show()
    }
}