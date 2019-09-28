package com.dmentors.solar_city.presentation.blog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.GlideApp
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_story_board.*

class StoryBoardAdapter(
    private val itemClick: (BlogStoryBoardItem) -> Unit,
    itemCallback: StoryBoardItemCallback = StoryBoardItemCallback()
) : ListAdapter<BlogStoryBoardItem, StoryBoardAdapter.StoryBoardItemViewHolder>(itemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryBoardItemViewHolder =
        StoryBoardItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_story_board, parent, false)
        )

    override fun onBindViewHolder(holder: StoryBoardItemViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class StoryBoardItemViewHolder(override val containerView: View)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(item: BlogStoryBoardItem) {
            GlideApp.with(itemView.context)
                .load(item.image)
                .centerCrop()
                .into(itemStoryBoardImage)
            itemStoryBoardBackground.visibility = when (item.isShowed) {
                true -> GONE
                false -> VISIBLE
            }
            itemStoryBoardImage.setOnClickListener { itemClick.invoke(item) }
        }
    }
}