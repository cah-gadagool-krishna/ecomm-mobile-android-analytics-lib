package com.cardinalhealth.orderexpress.utils.analytics

import android.content.Context
import com.flurry.android.FlurryAgent
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.InvalidObjectException
import javax.inject.Inject

/**
 * This class post the Flurry analytics event
 * @param context Used to get user information
 * @param mappingList Hold analytics keys
 */
class FlurryAnalyticsProvider @Inject constructor(
    @ApplicationContext private val context: Context,
    private val analyticsHelper: AnalyticsHelper
) : IAnalyticsProvider {

    override fun setUserId(userId: String) {
        FlurryAgent.setUserId(userId)
    }

    override fun onPageView() {
        // To be implemented in case useful
    }

    override fun logEvent(commonKey: String) {
        if (commonKey.startsWith("@")) {
            InvalidObjectException("Parameter is missing.")
        } else {
            FlurryAgent.logEvent(
                analyticsHelper.getMappingList().find { it.commonKey == commonKey }?.commonKey.orEmpty()
            )
        }
    }

    override fun logEvent(commonKey: String, data: Map<String, String>) {
        if (data.isNullOrEmpty()) {
            InvalidObjectException("Event data is empty")
        } else {
            FlurryAgent.logEvent(
                analyticsHelper.getMappingList().find { it.commonKey == commonKey }?.commonKey.orEmpty(),
                data
            )
        }
    }

    override fun logEvent(pageName: String, actionType: String, dataMap: HashMap<String, String>) {
        // Overloaded method used with three params
    }
}