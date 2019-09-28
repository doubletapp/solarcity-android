package com.dmentors.solar_city.presentation.blog.adapter

import java.util.*
import kotlin.collections.ArrayList

data class BlogItem(
    var itemType: Type = Type.STORY_BOARD,
    val id: String = UUID.randomUUID().toString(),
    var stories: ArrayList<BlogStoryBoardItem> = ArrayList(),
    var avatar: String? = null,
    var userName: String? = null,
    var role: String? = null,
    var text: String? = null,
    var image: String? = null,
    var imageTitle: String? = null,
    var imageSubtitle: String? = null,
    var date: String? = null,
    var likeCount: Int = 0,
    var isLiked: Boolean = false,
    var location: String? = null,
    var rating: Double = 0.0
) {
    enum class Type { STORY_BOARD, ARTICLE, REPORT }
}