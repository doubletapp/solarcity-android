package com.dmentors.solar_city.presentation.chat

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_chat.*


class ChatFragment : BaseFragment<ChatViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_chat

    companion object {
        fun newInstance(title: String) = ChatFragment().apply {
            arguments = Bundle().apply {
                putString("str", title)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chatTitle.text = arguments?.getString("str", "") ?: ""
        chatBack.setOnClickListener {
            val imm: InputMethodManager =
                context!!.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
            activity?.onBackPressed()
        }
    }
}