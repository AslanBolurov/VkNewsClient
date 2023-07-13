package com.sumincourse.vknewsclient.domain

import com.sumincourse.vknewsclient.R

data class FeedPost(
    val id: Int = 0,
    val communityName: String = "/dev/null",
    val publicationDate: String = "14:00",
    val avatarResId: Int = R.drawable.post_comunity_thumbnail,
    val contentText: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    val contentImageResId: Int = R.drawable.post_content_image,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(StatisticsType.VIEWS, 966),
        StatisticItem(StatisticsType.SHARES, 7),
        StatisticItem(StatisticsType.COMMENTS, 8),
        StatisticItem(StatisticsType.LIKES, 27)
    )
)
