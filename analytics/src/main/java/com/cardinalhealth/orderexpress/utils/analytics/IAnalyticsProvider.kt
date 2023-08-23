package com.cardinalhealth.orderexpress.utils.analytics

interface IAnalyticsProvider {
    fun logEvent(commonKey: String)
    fun logEvent(commonKey: String, data: Map<String, String>)
    fun logEvent(pageName: String, actionType: String, dataMap: HashMap<String, String>)
    fun setUserId(userId: String)
    fun onPageView()
}