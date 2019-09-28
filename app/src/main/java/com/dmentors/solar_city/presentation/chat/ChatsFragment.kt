package com.dmentors.solar_city.presentation.chat

import android.os.Bundle
import android.view.View
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_chats.*

class ChatsFragment : BaseFragment<ChatsViewModel>() {
    override fun getLayoutId(): Int = R.layout.fragment_chats

    companion object {
        fun newInstance() = ChatsFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chatsCurator.setOnClickListener { showChat(chatsCuratorTitle.text.toString()) }
        chatsMentor.setOnClickListener { showChat(chatsMentorTitle.text.toString()) }
        chatsPsycho.setOnClickListener { showChat(chatsPsychoTitle.text.toString()) }
    }

    fun showChat(title: String) {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(android.R.id.content, ChatFragment.newInstance(title))
            ?.addToBackStack(null)
            ?.commit()
    }
}