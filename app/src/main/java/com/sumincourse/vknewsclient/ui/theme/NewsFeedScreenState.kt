package com.sumincourse.vknewsclient.ui.theme

import com.sumincourse.vknewsclient.domain.FeedPost
import com.sumincourse.vknewsclient.domain.PostComment

sealed class NewsFeedScreenState {

    object Initial: NewsFeedScreenState()

    data class Posts(val posts: List<FeedPost>) : NewsFeedScreenState()

}
