package com.ekoapp.ekosdk.uikit.community.newsfeed.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ekoapp.ekosdk.feed.EkoPost
import com.ekoapp.ekosdk.uikit.community.R
import com.ekoapp.ekosdk.uikit.community.domain.model.FileAttachment
import com.ekoapp.ekosdk.uikit.community.newsfeed.listener.IPostFileItemClickListener

const val MAX_ITEM_TO_DISPLAY = 5

class EkoPostViewFileAdapter() : EkoBaseFeedAttachmentAdapter() {

    private var loadMoreFilesClickListener: ILoadMoreFilesClickListener? = null
    private var fileItemClickListener: IPostFileItemClickListener? = null
    private var newsFeed: EkoPost? = null
    private var collapsible: Boolean = false

    constructor(fileItemClickListener: IPostFileItemClickListener?) : this() {
        this.fileItemClickListener = fileItemClickListener
    }

    constructor(
            loadMoreFilesClickListener: ILoadMoreFilesClickListener?,
            fileItemClickListener: IPostFileItemClickListener?,
            newsFeed: EkoPost,
            collapsible: Boolean
    ) : this() {
        this.collapsible = collapsible
        this.loadMoreFilesClickListener = loadMoreFilesClickListener
        this.fileItemClickListener = fileItemClickListener
        this.newsFeed = newsFeed
    }

    override fun getLayoutId(position: Int, obj: FileAttachment?): Int {
        return if (collapsible && position == MAX_ITEM_TO_DISPLAY) {
            R.layout.layout_view_post_file_item_footer
        } else {
            R.layout.layout_view_post_file_item
        }
    }

    override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == R.layout.layout_view_post_file_item_footer) {
            EkoViewPostFileFooterViewHolder(view, loadMoreFilesClickListener, newsFeed)
        } else {
            EkoBaseFeedAttachmentViewHolder(view, fileItemClickListener)
        }
    }

    /* Max allowed item to display is file*/
    override fun getItemCount(): Int {
        return if (collapsible && list.size > MAX_ITEM_TO_DISPLAY) {
            MAX_ITEM_TO_DISPLAY + 1
        } else {
            super.getItemCount()
        }
    }

    interface ILoadMoreFilesClickListener {
        fun loadMoreFiles(post: EkoPost)
    }
}