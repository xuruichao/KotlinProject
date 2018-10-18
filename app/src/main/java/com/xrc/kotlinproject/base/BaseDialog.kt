package com.xrc.kotlinproject.base

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * BaseDialog
 * Created by xrc on 18/10/17.
 */
abstract class BaseDialog : DialogFragment() {

    lateinit var mDialog: Dialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(getLayoutId(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Holo_Light_Dialog_MinWidth)
        mDialog = dialog
        val dialogWindow = mDialog.window
        dialogWindow!!.setBackgroundDrawableResource(android.R.color.transparent)
        val dm = DisplayMetrics()
        activity!!.windowManager.defaultDisplay.getMetrics(dm)
        dialogWindow.setLayout(dm.widthPixels, ViewGroup.LayoutParams.WRAP_CONTENT)
        //设置竖直方向偏移量
        val attributes = dialogWindow.attributes
        attributes.gravity = getGravity()
        attributes.x = getHorizontalMovement().toInt()
        attributes.y = getVerticalMovement().toInt()
        dialogWindow.attributes = attributes
        init(arguments)
    }

    private fun getGravity(): Int {
        return Gravity.CENTER
    }

    /**
     * 设置竖直方向偏移量
     *
     * @return 返回负值是向上偏移 正值是向下偏移 单位dp 例如：想向上偏移20dp，return -20 即可，无需转换
     */
    protected fun getVerticalMovement(): Float {
        return 0f
    }

    /**
     * 设置竖直方向偏移量
     *
     * @return 返回负值是向左偏移 正值是向右偏移 单位dp 例如：想向左偏移20dp，return -20 即可，无需转换
     */
    protected fun getHorizontalMovement(): Float {
        return 0f
    }

    abstract fun init(bundle: Bundle?)

    abstract fun getLayoutId(): Int

    fun show(manager: FragmentManager) {
        show(manager, javaClass.name)
    }
}