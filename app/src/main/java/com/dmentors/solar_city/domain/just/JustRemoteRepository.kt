package com.dmentors.solar_city.domain.just

import com.dmentors.solar_city.base.ApiErrorHandler
import com.dmentors.solar_city.base.BaseRemoteRepository

class JustRemoteRepository(
    apiErrorHandler: ApiErrorHandler,
    private val justRetrofit: JustRetrofit
) : BaseRemoteRepository(apiErrorHandler) {

}