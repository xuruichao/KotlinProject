package com.xrc.kotlinproject.base

import android.annotation.SuppressLint
import android.app.Application

/**
 * ProjectApplication
 * Created by xrc on 18/10/16.
 */
class ProjectApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var INSTANCE: Application? = null

        fun instance(): Application? {
            return INSTANCE
        }
    }

}