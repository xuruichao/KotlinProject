package com.xrc.kotlinproject.util

import android.content.Context
import android.content.SharedPreferences
import com.xrc.kotlinproject.base.ProjectApplication
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.ObjectOutputStream
import kotlin.reflect.KProperty

/**
 * Created by xrc on 18/10/22.
 */
class Preference<T>(val name: String, private val defaultValue: T) {

    operator fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        setSpValue(name, value)
    }

    operator fun getValue(thisRef: Any, property: KProperty<*>): T? {
        return getSpValue()
    }

    companion object {
        private const val FILE_NAME: String = "kotlin_project"

        private val sp: SharedPreferences by lazy {
            ProjectApplication.instance().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        }

    }

    private fun setSpValue(name: String, value: T) = with(sp.edit()) {
        when (value) {
            is String -> putString(name, value)
            is Boolean -> putBoolean(name, value)
            else -> putString(name, serialize(value))
        }
    }?.apply()

    private fun getSpValue(): T = with(sp) {
        val res: Any = when (defaultValue) {
            is String -> getString(name, defaultValue)
            is Boolean -> getBoolean(name, defaultValue)
            else -> {
                ""
            }
        }
        @Suppress("UNCHECKED_CAST")
        return res as T
    }

    @Throws(IOException::class)
    private fun <A> serialize(obj: A): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val objectOutputStream = ObjectOutputStream(
                byteArrayOutputStream)
        objectOutputStream.writeObject(obj)
        var serStr = byteArrayOutputStream.toString("ISO-8859-1")
        serStr = java.net.URLEncoder.encode(serStr, "UTF-8")
        objectOutputStream.close()
        byteArrayOutputStream.close()
        return serStr
    }
}