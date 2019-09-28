package com.dmentors.solar_city.domain.main

import com.dmentors.solar_city.base.ApiErrorHandler
import com.dmentors.solar_city.base.BaseRemoteRepository

class MainRemoteRepository(
    private val mainRetrofit: MainRetrofit,
    apiErrorHandler: ApiErrorHandler
) : BaseRemoteRepository(apiErrorHandler) {

}