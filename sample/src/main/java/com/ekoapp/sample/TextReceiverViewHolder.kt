package com.ekoapp.sample

import android.view.View
import androidx.databinding.DataBindingUtil
import com.ekoapp.ekosdk.message.EkoMessage
import com.ekoapp.ekosdk.uikit.chat.messages.viewHolder.EkoChatMessageBaseViewHolder
import com.ekoapp.sample.databinding.ItemTextReceiverBinding

class TextReceiverViewHolder(
        itemView: View,
        private val itemViewModel: MyTextMsgViewModel
) : EkoChatMessageBaseViewHolder(itemView, itemViewModel) {

    private val binding: ItemTextReceiverBinding? = DataBindingUtil.bind(itemView)

    init {
        binding?.viewModel = itemViewModel
    }

    override fun setMessage(message: EkoMessage) {
        val data = message.getData() as EkoMessage.Data.TEXT
        val text = data.getText()
        /**
         * Data binding can be used to set the views
         */
        itemViewModel.text.set(text)

        /**
         * Alternatively individual views can be set
         */
        binding?.tvMsgReceiver?.text = text
        binding?.tvTime?.text = itemViewModel.msgTime.get()
    }
}