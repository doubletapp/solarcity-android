package com.dmentors.solar_city.presentation.main

import com.dmentors.solar_city.base.BaseViewModel
import com.dmentors.solar_city.domain.main.MainInteractor
import javax.inject.Inject

class MainViewModel
@Inject
constructor(
    private val mainInteractor: MainInteractor
) : BaseViewModel() {

}