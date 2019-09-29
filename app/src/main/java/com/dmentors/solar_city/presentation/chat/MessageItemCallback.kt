package com.dmentors.solar_city.presentation.chat

import androidx.recyclerview.widget.DiffUtil

class MessageItemCallback : DiffUtil.ItemCallback<Message>() {

    override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean =
        oldItem.type == newItem.type
                && oldItem.message == newItem.message
}