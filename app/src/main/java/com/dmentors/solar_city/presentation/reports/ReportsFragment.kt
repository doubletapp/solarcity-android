package com.dmentors.solar_city.presentation.reports

import android.view.View
import androidx.core.content.ContextCompat
import com.dmentors.solar_city.ArchApplication
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_report.*

class ReportsFragment : BaseFragment<ReportsViewModel>() {

    companion object {
        const val TAG = "ReportsFragment"
    }

    override fun getLayoutId(): Int = R.layout.fragment_report

    override fun initViews() {

        reportCurrent.setOnClickListener {
            reportMockFilled.visibility = View.GONE
            reportMockCurrent.visibility = View.VISIBLE

            currentTxt1.setTextColor(
                ContextCompat.getColor(
                    filledTxt1.context,
                    android.R.color.black
                )
            )
            currentTxt2.setTextColor(
                ContextCompat.getColor(
                    filledTxt1.context,
                    android.R.color.black
                )
            )
            filledTxt1.setTextColor(
                ContextCompat.getColor(
                    filledTxt1.context,
                    android.R.color.white
                )
            )
            filledTxt2.setTextColor(
                ContextCompat.getColor(
                    filledTxt1.context,
                    android.R.color.white
                )
            )

            reportCurrent.setCardBackgroundColor(
                ContextCompat.getColorStateList(
                    reportCurrent.context,
                    android.R.color.white
                )
            )
            reportFilled.setCardBackgroundColor(
                ContextCompat.getColorStateList(
                    reportCurrent.context,
                    R.color.cloudyBlueCard
                )
            )
        }
        reportFilled.setOnClickListener {
            reportMockFilled.visibility = View.VISIBLE
            reportMockCurrent.visibility = View.GONE


            filledTxt1.setTextColor(
                ContextCompat.getColor(
                    filledTxt1.context,
                    android.R.color.black
                )
            )
            filledTxt2.setTextColor(
                ContextCompat.getColor(
                    filledTxt1.context,
                    android.R.color.black
                )
            )
            currentTxt1.setTextColor(
                ContextCompat.getColor(
                    filledTxt1.context,
                    android.R.color.white
                )
            )
            currentTxt2.setTextColor(
                ContextCompat.getColor(
                    filledTxt1.context,
                    android.R.color.white
                )
            )

            reportFilled.setCardBackgroundColor(
                ContextCompat.getColorStateList(
                    reportCurrent.context,
                    android.R.color.white
                )
            )
            reportCurrent.setCardBackgroundColor(
                ContextCompat.getColorStateList(
                    reportCurrent.context,
                    R.color.cloudyBlueCard
                )
            )
        }
        reportAddBtn.setOnClickListener {

        }

    }
}