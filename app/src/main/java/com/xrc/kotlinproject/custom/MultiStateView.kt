package com.xrc.kotlinproject.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.xrc.kotlinproject.R
import kotlinx.android.synthetic.main.multi_state_view.view.*

/**
 * MultiStateView
 * Created by xrc on 18/10/16.
 */
class MultiStateView(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs), View.OnClickListener {

    var listener: OnRetryListener? = null

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.multi_state_view, this,
                false)
        addView(view)
        tv_state.setOnClickListener(this)
    }

    private fun loading() {
        showLoadingHideText()
        tv_state.isEnabled = false
    }

    fun normal() {
        hideTextAndLoading()
        tv_state.isEnabled = false
    }

    fun empty() {
        showTextHideLoading()
        setStateText("空空如也！")
        tv_state.isEnabled = true
    }

    fun error() {
        showTextHideLoading()
        setStateText("网络加载失败了！")
        tv_state.isEnabled = true
    }

    private fun showTextHideLoading() {
        tv_state.visibility = View.VISIBLE
        pb_state_view.visibility = View.GONE
    }

    private fun hideTextAndLoading() {
        tv_state.visibility = View.GONE
        pb_state_view.visibility = View.GONE
    }

    private fun showLoadingHideText() {
        tv_state.visibility = View.GONE
        pb_state_view.visibility = View.VISIBLE
    }

    private fun setStateText(text: CharSequence) {
        tv_state.text = text
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_state -> {
                loading()
                if (listener != null) {
                    listener?.onRetry()
                }
            }
        }
    }

    interface OnRetryListener {
        fun onRetry()
    }
}