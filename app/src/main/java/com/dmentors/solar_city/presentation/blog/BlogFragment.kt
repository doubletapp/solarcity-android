package com.dmentors.solar_city.presentation.blog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseFragment
import com.dmentors.solar_city.presentation.blog.adapter.BlogAdapter
import com.dmentors.solar_city.presentation.calendar.CalendarFragment
import com.dmentors.solar_city.presentation.main.MainActivity
import com.dmentors.solar_city.utils.Mocker
import kotlinx.android.synthetic.main.fragment_blog.*

class BlogFragment : BaseFragment<BlogViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_blog

    companion object {
        fun newInstance() = BlogFragment()
    }

    private val blogAdapter by lazy { BlogAdapter({}, {}, {}) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        blogRecycler.adapter = blogAdapter
        blogAdapter.submitList(Mocker.mockBlog())
        blogAdd.setOnClickListener {
            (activity as MainActivity)
                .replaceFragment(CalendarFragment.newInstance(), android.R.id.content, "Calendar")
        }
    }
}