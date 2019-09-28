package com.dmentors.solar_city.presentation.just


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseFragment

class JustFragment : BaseFragment<JustViewModel>() {

    companion object {
        const val TAG = "JustFragment"
        fun newInstance(): JustFragment =
            JustFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_just, container, false)
    }
}
