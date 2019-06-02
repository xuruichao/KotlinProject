package com.xrc.kotlinproject.dialog

import android.os.Bundle
import com.xrc.kotlinproject.R
import com.xrc.kotlinproject.base.BaseDialog
import kotlinx.android.synthetic.main.dialog_normal.*

/**
 * NormalDialog
 * Created by xrc on 18/10/18.
 */
class NormalDialog : BaseDialog() {

    override fun init(bundle: Bundle?) {
        if (bundle != null) {
            val content: String = bundle[CONTENT] as String
            tv_content.text = content
        }
    }

    companion object {
        private const val CONTENT: String = "content"
        fun newInstance(text: String = "此处显示内容"): NormalDialog {
            val dialog = NormalDialog()
            val bundle = Bundle()
            bundle.putString(CONTENT, text)
            dialog.arguments = bundle
            return dialog
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.dialog_normal
    }

}