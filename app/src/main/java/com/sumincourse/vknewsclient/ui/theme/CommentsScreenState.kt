package com.sumincourse.vknewsclient.ui.theme

import com.sumincourse.vknewsclient.domain.FeedPost
import com.sumincourse.vknewsclient.domain.PostComment

sealed class CommentsScreenState {
    object Initial: CommentsScreenState()

    data class Comments(val feedPost: FeedPost,val comments: List<PostComment>) : CommentsScreenState()
}