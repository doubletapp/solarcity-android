package com.dmentors.solar_city.presentation.recommendation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseFragment

class RecommendationFragment : BaseFragment<RecommendationViewModel>() {

    companion object {
        fun newInstance() = RecommendationFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_recommendation, container, false)
}