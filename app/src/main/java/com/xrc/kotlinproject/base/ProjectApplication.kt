package com.xrc.kotlinproject.base

import android.annotation.SuppressLint
import android.app.Application

/**
 * ProjectApplication
 * Created by xrc on 18/10/16.
 */
open class ProjectApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var INSTANCE: Application

        fun instance(): Application {
            return INSTANCE
        }
    }

}