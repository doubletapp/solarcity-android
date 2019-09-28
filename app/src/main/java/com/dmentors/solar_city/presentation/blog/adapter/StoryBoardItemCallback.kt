package com.dmentors.solar_city.presentation.blog.adapter

import androidx.recyclerview.widget.DiffUtil

class StoryBoardItemCallback : DiffUtil.ItemCallback<BlogStoryBoardItem>() {
    override fun areItemsTheSame(
        oldItem: BlogStoryBoardItem,
        newItem: BlogStoryBoardItem
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: BlogStoryBoardItem,
        newItem: BlogStoryBoardItem
    ): Boolean = oldItem.image == newItem.image
            && oldItem.slides == newItem.slides
            && oldItem.isShowed == newItem.isShowed
}