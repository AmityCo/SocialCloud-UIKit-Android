package com.ekoapp.ekosdk.uikit.community.newsfeed.listener

import com.ekoapp.ekosdk.user.EkoUser

interface IAvatarClickListener {
    fun onClickUserAvatar(user: EkoUser)
}