package com.dmentors.solar_city.utils

import com.dmentors.solar_city.presentation.blog.adapter.BlogItem
import com.dmentors.solar_city.presentation.blog.adapter.BlogStoryBoardItem

object Mocker {

    fun mockBlog(): List<BlogItem> = ArrayList<BlogItem>().run {
        add(
            BlogItem(itemType = BlogItem.Type.STORY_BOARD,
            stories = ArrayList<BlogStoryBoardItem>().run internal@{
                add(BlogStoryBoardItem("https://sun9-4.userapi.com/c857524/v857524914/87828/QyyztvTjNPU.jpg"))
                add(BlogStoryBoardItem("https://sun9-12.userapi.com/c857524/v857524914/8781a/q6TjhUnHT7U.jpg"))
                add(BlogStoryBoardItem("https://sun9-45.userapi.com/c857524/v857524914/87821/hGEabYe0Vfw.jpg"))
                return@internal this
            })
        )
        add(
            BlogItem(itemType = BlogItem.Type.ARTICLE,
                avatar = "https://sun9-36.userapi.com/c858024/v858024622/87c14/DyyEdHPXmXo.jpg",
                userName = "Анастасия Землянова",
                role = "Куратор проекта",
                text = "В статье рассматриваются проблемы социальной адаптации и постинтернатного сопровождения выпускников детских домов.",
                image = "https://image.freepik.com/free-photo/close-up-kid-playing-with-jenga-pieces_23-2148243700.jpg",
                imageTitle = "Основные права и гарантии выпускников детского дома",
                imageSubtitle = "24 сентября, 14:00",
                likeCount = 15,
                isLiked = true,
                date = "14 сентября")
        )
        add(
            BlogItem(itemType = BlogItem.Type.REPORT,
                avatar = "https://sun9-18.userapi.com/c628131/v628131898/264c9/qzRNvOY07WM.jpg",
                userName = "Валерия Баркова",
                location = "Картинг на Ленина",
                text = "Сходили с Настей на картинг. Попался очень вежливый инструктор. Замечательно провели время ❤️",
                image = "https://sun9-6.userapi.com/c858416/v858416914/89dc1/ZPa6LssVPdA.jpg",
                rating = 4.5,
                likeCount = 15,
                isLiked = false,
                date = "14 сентября")
        )
        return@run this
    }
}