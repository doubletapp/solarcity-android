package com.dmentors.solar_city.view

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.CheckBox
import com.dmentors.solar_city.R

class CheckBox(
    context: Context,
    attrs: AttributeSet
) : CheckBox(context, attrs) {

    init {
        buttonDrawable = null
        setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check, 0)
        typeface = resources.getFont(R.font.geometria_regular)
        setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.text_size_16))
        setTextColor(resources.getColor(R.color.textColorGray, null))
        val startPadding = resources.getDimensionPixelSize(R.dimen.check_box_start_padding)
        val topPadding = resources.getDimensionPixelSize(R.dimen.check_box_top_padding)
        val endPadding = resources.getDimensionPixelSize(R.dimen.check_box_end_padding)
        setPadding(startPadding, topPadding, endPadding, topPadding)
        compoundDrawablePadding = startPadding
        ellipsize = TextUtils.TruncateAt.END
        maxLines = 1
        background = null
    }
}