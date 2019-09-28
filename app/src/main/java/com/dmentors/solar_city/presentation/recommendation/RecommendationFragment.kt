package com.dmentors.solar_city.presentation.recommendation

import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseFragment

class RecommendationFragment : BaseFragment<RecommendationViewModel>() {
    override fun getLayoutId(): Int = R.layout.fragment_recommendation

    companion object {
        fun newInstance() = RecommendationFragment()
    }
}