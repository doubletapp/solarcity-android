package com.dmentors.solar_city.presentation.stories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dmentors.solar_city.R
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.fragment_stories.*


class StoriesFragment : Fragment() {

    companion object {
        const val TAG = "StoriesFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_stories, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        storiesViewPager.adapter = StoriesViewPagerAdapter(childFragmentManager)
        storiesTabLayout.setupWithViewPager(storiesViewPager)

        storiesClose.setOnClickListener {
            activity?.onBackPressed()
        }
        storiesClickNextLayout.setOnClickListener {
            if (storiesViewPager.currentItem == 0) {
                storiesViewPager.setCurrentItem(1, true)
            } else {
                activity?.onBackPressed()
            }
        }
    }
}

class StoriesViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(i: Int): Fragment {
        return StoryPagerFragment.newInstance(i + 1)
    }

    override fun getCount(): Int {
        return 2
    }
}