package com.dmentors.solar_city.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseFragment
import com.dmentors.solar_city.base.BaseNavigationActivity
import com.dmentors.solar_city.base.GlideApp
import com.dmentors.solar_city.presentation.calendar.CalendarFragment
import com.dmentors.solar_city.presentation.main.MainActivity
import com.dmentors.solar_city.presentation.reports.ReportsFragment
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment<ProfileViewModel>() {
    override fun getLayoutId(): Int = R.layout.fragment_profile

    companion object {
        fun newInstance() = ProfileFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GlideApp.with(view)
            .load("https://sun9-18.userapi.com/c628131/v628131898/264c9/qzRNvOY07WM.jpg")
            .centerCrop()
            .into(profileAvatar)

        profileCalendarButton.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(android.R.id.content, CalendarFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
        }

        profileHistoryButton.setOnClickListener {
            (activity as BaseNavigationActivity<*>)
                .replaceFragment(
                    ReportsFragment(),
                    android.R.id.content,
                    ReportsFragment.TAG
                )
        }
    }
}