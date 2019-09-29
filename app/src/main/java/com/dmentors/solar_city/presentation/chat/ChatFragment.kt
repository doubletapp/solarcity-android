package com.dmentors.solar_city.presentation.chat

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_chat.*


class ChatFragment : BaseFragment<ChatViewModel>() {

    companion object {
        fun newInstance(title: String) = ChatFragment().apply {
            arguments = Bundle().apply {
                putString("str", title)
            }
        }
    }

    private val chatAdapter by lazy { ChatAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_chat, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chatTitle.text = arguments?.getString("str", "") ?: ""
        chatBack.setOnClickListener {
            val imm: InputMethodManager =
                context!!.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
            activity?.onBackPressed()
        }
        chatRecycler.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                setDrawable(
                    ContextCompat.getDrawable(
                        context!!,
                        R.drawable.story_separator
                    )!!
                )
            }
        )
        chatRecycler.adapter = chatAdapter
        chatRecycler.setItemAnimator(object : DefaultItemAnimator() {
            override fun onAnimationFinished(viewHolder: RecyclerView.ViewHolder) {
                chatRecycler.smoothScrollToPosition(0)
            }
        })
        chatSendButton.setOnClickListener {
            viewModel.sendMessage(chatSendText.text.toString())
            chatAdapter.addMessage(Message(Message.Type.SELF, chatSendText.text.toString()))
            chatSendText.text.clear()
        }
        viewModel.message.observe(this, Observer {
            it?.let {
                chatAdapter.addMessage(it)
            }
        })
    }
}