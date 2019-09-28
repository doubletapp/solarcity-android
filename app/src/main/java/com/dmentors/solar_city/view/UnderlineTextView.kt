package com.dmentors.solar_city.view

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.TextView

class UnderlineTextView(context: Context?, attrs: AttributeSet?) : TextView(context, attrs) {

    init {
        paintFlags = paintFlags or Paint.UNDERLINE_TEXT_FLAG
    }
}