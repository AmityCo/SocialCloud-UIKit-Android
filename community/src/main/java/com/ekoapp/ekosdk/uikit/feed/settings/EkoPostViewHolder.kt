package com.ekoapp.ekosdk.uikit.feed.settings

import android.view.View
import com.ekoapp.ekosdk.uikit.community.newsfeed.adapter.NewsFeedViewHolder

interface EkoPostViewHolder {

    fun getDataType() : String

    fun getLayoutId() : Int

    fun createViewHolder(view: View) : NewsFeedViewHolder

}