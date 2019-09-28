package com.dmentors.solar_city.presentation.blog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.GlideApp
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_blog_article.*
import kotlinx.android.synthetic.main.item_blog_report.*
import kotlinx.android.synthetic.main.item_blog_story_board.*


class BlogAdapter(
    private val storyClickAction: (BlogStoryBoardItem) -> Unit,
    private val articleClickAction: (BlogItem) -> Unit,
    private val reportClickAction: (BlogItem) -> Unit,
    itemCallback: BlogItemCallback = BlogItemCallback()
) : ListAdapter<BlogItem, BlogAdapter.BlogViewHolder>(itemCallback) {

    companion object {
        const val TYPE_STORY_BOARD = 101
        const val TYPE_ARTICLE = 102
        const val TYPE_REPORT = 103
    }

    override fun getItemViewType(position: Int) = when (getItem(position).itemType) {
        BlogItem.Type.STORY_BOARD -> TYPE_STORY_BOARD
        BlogItem.Type.ARTICLE -> TYPE_ARTICLE
        BlogItem.Type.REPORT -> TYPE_REPORT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder =
        LayoutInflater.from(parent.context).let { inflater ->
            when (viewType) {
                TYPE_STORY_BOARD -> StoryBoardViewHolder(
                    inflater.inflate(
                        R.layout.item_blog_story_board,
                        parent,
                        false
                    )
                )
                TYPE_ARTICLE -> ArticleViewHolder(
                    inflater.inflate(
                        R.layout.item_blog_article,
                        parent,
                        false
                    )
                )
                else -> ReportViewHolder(inflater.inflate(R.layout.item_blog_report, parent, false))
            }
        }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class StoryBoardViewHolder(override val containerView: View) :
        BlogViewHolder(containerView) {
        override fun bind(item: BlogItem) {
            itemBlogStoryBoardRecycler.adapter = StoryBoardAdapter(storyClickAction).also {
                it.submitList(item.stories)
            }
            itemBlogStoryBoardRecycler.addItemDecoration(
                DividerItemDecoration(itemView.context, DividerItemDecoration.HORIZONTAL).apply {
                    setDrawable(
                        ContextCompat.getDrawable(
                            itemView.context,
                            R.drawable.story_separator
                        )!!
                    )
                }
            )
        }
    }

    inner class ArticleViewHolder(override val containerView: View) :
        BlogViewHolder(containerView) {
        override fun bind(item: BlogItem) {
            GlideApp.with(itemView.context)
                .load(item.avatar)
                .centerCrop()
                .into(itemBlogArticleAvatar)
            GlideApp.with(itemView.context)
                .load(item.image)
                .centerCrop()
                .into(itemBlogArticleImage)
            itemBlogArticleDate.text = item.date
            itemBlogArticleImageTitle.text = item.imageTitle
            itemBlogArticleImageSubtitle.text = item.imageSubtitle
            itemBlogArticleLikeCounter.text = item.likeCount.toString()
            itemBlogArticleUserName.text = item.userName
            itemBlogArticleUserRole.text = item.role
            itemBlogArticleText.text = item.text
            itemBlogArticleLike.isSelected = item.isLiked
            itemBlogArticleClick.setOnClickListener { articleClickAction.invoke(item) }
            itemBlogArticleLike.setOnClickListener {
                item.likeCount = when (item.isLiked) {
                    true -> (item.likeCount - 1).also { item.isLiked = false }
                    false -> (item.likeCount + 1).also { item.isLiked = true }
                }
                notifyItemChanged(adapterPosition)
            }
        }
    }

    inner class ReportViewHolder(override val containerView: View) : BlogViewHolder(containerView) {
        override fun bind(item: BlogItem) {
            GlideApp.with(itemView.context)
                .load(item.avatar)
                .centerCrop()
                .into(itemBlogReportAvatar)
            GlideApp.with(itemView.context)
                .load(item.image)
                .centerCrop()
                .into(itemBlogReportImage)
            itemBlogReportDate.text = item.date
            itemBlogReportLikeCounter.text = item.likeCount.toString()
            itemBlogReportUserName.text = item.userName
            itemBlogReportLocation.text = item.location
            itemBlogReportText.text = item.text
            itemBlogReportLike.isSelected = item.isLiked
            itemBlogReportRating.text = item.rating.toString()
            itemBlogReportClick.setOnClickListener { reportClickAction.invoke(item) }
            itemBlogReportLike.setOnClickListener {
                item.likeCount = when (item.isLiked) {
                    true -> (item.likeCount - 1).also { item.isLiked = false }
                    false -> (item.likeCount + 1).also { item.isLiked = true }
                }
                notifyItemChanged(adapterPosition)
            }
        }
    }

    abstract inner class BlogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        LayoutContainer {
        abstract fun bind(item: BlogItem)
    }
}