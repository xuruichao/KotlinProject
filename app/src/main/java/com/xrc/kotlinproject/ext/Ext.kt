package com.xrc.kotlinproject.ext

import android.util.Log
import com.xrc.kotlinproject.util.ToastUtil

/**
 * 扩展类
 * Created by xrc on 18/10/24.
 */
fun toast(text: CharSequence) {
    ToastUtil.showToast(text)
}

fun loge(tag: String, content: String) {
    Log.e(tag, content)
}

