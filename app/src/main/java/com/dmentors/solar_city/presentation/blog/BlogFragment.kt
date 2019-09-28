package com.dmentors.solar_city.presentation.blog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseFragment
import com.dmentors.solar_city.presentation.blog.adapter.BlogAdapter
import com.dmentors.solar_city.utils.Mocker
import kotlinx.android.synthetic.main.fragment_blog.*

class BlogFragment : BaseFragment<BlogViewModel>() {

    companion object {
        fun newInstance() = BlogFragment()
    }

    private val blogAdapter by lazy { BlogAdapter({}, {}, {}) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_blog, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        blogRecycler.adapter = blogAdapter
        blogAdapter.submitList(Mocker.mockBlog())
    }
}