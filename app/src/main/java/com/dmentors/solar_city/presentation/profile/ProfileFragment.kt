package com.dmentors.solar_city.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseFragment
import com.dmentors.solar_city.base.GlideApp
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment<ProfileViewModel>() {
    override fun getLayoutId(): Int = R.layout.fragment_profile

    companion object {
        fun newInstance() = ProfileFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GlideApp.with(view)
            .load("https://static.independent.co.uk/s3fs-public/thumbnails/image/2019/07/21/10/avatar-neytiri.jpg")
            .centerCrop()
            .into(profileAvatar)
    }
}