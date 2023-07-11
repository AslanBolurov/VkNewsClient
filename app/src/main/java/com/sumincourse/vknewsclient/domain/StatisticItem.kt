package com.sumincourse.vknewsclient.domain

data class StatisticItem(

    val type:StatisticsType,
    val count:Int=0

)

enum class StatisticsType {
    VIEWS, COMMENTS, SHARES, LIKES
}