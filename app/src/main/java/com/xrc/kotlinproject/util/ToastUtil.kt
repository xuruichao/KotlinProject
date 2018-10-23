package com.xrc.kotlinproject.util

import android.widget.Toast
import com.xrc.kotlinproject.base.ProjectApplication

/**
 * ToastUtil
 * Created by xrc on 18/10/16.
 */
object ToastUtil {
    fun showToast(text: String) {
        Toast.makeText(ProjectApplication.instance(), text, Toast.LENGTH_SHORT).show()
    }
}