package com.dmentors.solar_city.presentation.blog.adapter

import java.util.*
import kotlin.collections.ArrayList

data class BlogStoryBoardItem(
    var image: String?,
    var isShowed: Boolean = false,
    var slides: ArrayList<String> = ArrayList(),
    val id: String = UUID.randomUUID().toString()
)