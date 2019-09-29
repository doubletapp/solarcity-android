package com.dmentors.solar_city.presentation.stories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dmentors.solar_city.R
import kotlinx.android.synthetic.main.fragment_stories_pager.*

class StoryPagerFragment : Fragment() {

    private var position: Int = 1

    companion object {

        fun newInstance(position: Int): StoryPagerFragment {
            val fragment = StoryPagerFragment()
            fragment.position = position
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_stories_pager, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        when (position) {
            1 -> {
                storiesImageView.setImageResource(R.drawable.picture_1)
            }
            else -> {
                storiesImageView.setImageResource(R.drawable.picture_2)
            }
        }
    }
}