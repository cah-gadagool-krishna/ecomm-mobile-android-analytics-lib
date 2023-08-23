package com.cardinalhealth.orderexpress.utils.analytics

import android.content.Context
import com.adobe.marketing.mobile.MobileCore
import com.cardinalhealth.orderexpress.core.analytics.BuildConfig
import com.cardinalhealth.orderexpress.core.common.COMMA_SEPARATOR
import com.cardinalhealth.orderexpress.core.common.EMPTY_STRING
import com.cardinalhealth.orderexpress.core.common.TIME_FORMAT
import com.cardinalhealth.orderexpress.core.common.getAnalyticsAppVersion
import com.cardinalhealth.orderexpress.model.preferences.SharedPreferenceManager
import com.cardinalhealth.orderexpress.view.AdobeScanHelper
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber
import java.io.InvalidObjectException
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject

/**
 * This class post adobe analytics events
 * @param context Used to get user information
 */
class AdobeAnalyticsProvider @Inject constructor(
    @ApplicationContext val context: Context,
    private val storefrontUtils: StorefrontUtils,
    private val sharedPreferenceManager: SharedPreferenceManager
) : IAnalyticsProvider {
    override fun setUserId(userId: String) {
        // This method implementation is not required in for adobe analytics
    }

    override fun logEvent(commonKey: String) {
        // Overloaded method used with one param
    }

    override fun logEvent(commonKey: String, data: Map<String, String>) {
        // Overloaded method used with two params
    }

    override fun logEvent(pageName: String, actionType: String, dataMap: HashMap<String, String>) {
        if (dataMap.isNullOrEmpty() || pageName.isNullOrEmpty()) {
            InvalidObjectException("Event data is empty")
            return
        }
        //Common properties for all events goes here
        val timeFormatter = SimpleDateFormat(TIME_FORMAT)

        // Get share preference manager
        var programmingCodes = EMPTY_STRING
        sharedPreferenceManager.getSelectedAccount()?.marketingPrograms?.forEach {
            programmingCodes += it.code
            programmingCodes += COMMA_SEPARATOR
        }
        val memberGroupList = sharedPreferenceManager.getUserSettings()?.memberGroups ?: emptyList()

        // Set default properties
        dataMap[AnalyticsConstants.PROPERTY_CID] = EMPTY_STRING
        dataMap[AnalyticsConstants.PROPERTY_CC] = AnalyticsConstants.USD
        dataMap[AnalyticsConstants.PROPERTY_C1] = AnalyticsConstants.PHARMA_MOBILE
        dataMap[AnalyticsConstants.PROPERTY_V2] =
            AnalyticsConstants.D_EQUAL_TO + AnalyticsConstants.PROPERTY_C3
        dataMap[AnalyticsConstants.PROPERTY_V11] = sharedPreferenceManager.getCurrentLoggedInUser()
        dataMap[AnalyticsConstants.PROPERTY_V12] =
            sharedPreferenceManager.getSelectedAccount()?.id ?: AnalyticsConstants.EMPTY_STRING
        dataMap[AnalyticsConstants.PROPERTY_V15] =
            storefrontUtils.getStoreFront(programmingCodes, memberGroupList) ?: EMPTY_STRING
        dataMap[AnalyticsConstants.PROPERTY_V16] = AdobeScanHelper.getCurrentDate()
        dataMap[AnalyticsConstants.PROPERTY_V17] = timeFormatter.format(Date().time)
        dataMap[AnalyticsConstants.PROPERTY_V58] =
            sharedPreferenceManager.getUserRolesCommaSeparated()
        dataMap[AnalyticsConstants.PROPERTY_C23] = getAnalyticsAppVersion()
        dataMap[AnalyticsConstants.PROPERTY_C25] = BuildConfig.BUILD_TYPE
        dataMap[AnalyticsConstants.PROPERTY_V31] = programmingCodes
        dataMap[AnalyticsConstants.PROPERTY_C55] = AnalyticsManager.mid
        dataMap[AnalyticsConstants.PROPERTY_V55] = AnalyticsManager.mid
        dataMap[AnalyticsConstants.PROPERTY_C34] = getAnalyticsStringForEmergencyOrderingState()
        try {
            if (actionType == AnalyticsConstants.EVENT_TYPE_TRACK_STATE) {
                dataMap[AnalyticsConstants.PROPERTY_V1] =
                    AnalyticsConstants.D_EQUAL_TO + AnalyticsConstants.PROPERTY_PAGE_NAME
                MobileCore.trackState(
                    AnalyticsConstants.KEY_CAH_OE_MOBILE + pageName, dataMap
                )
            } else if (actionType == AnalyticsConstants.EVENT_TYPE_TRACK_ACTION) {
                MobileCore.trackAction(
                    AnalyticsConstants.KEY_CAH_OE_MOBILE + pageName, dataMap
                )
            }
        } catch (e: Exception) {
            Timber.e(e)
        }
        Timber.d("AdobeAnalytics Console (with map data) : $pageName")
    }

    override fun onPageView() {
        Timber.d("AdobeAnalytics Console (onPageView)")
    }

    /**
     * Get value based on Emergency ordering state
     */
//    private fun getAnalyticsStringForEmergencyOrderingState(): String {
//        return when (EmergencyOrderingManager.getEmergencyState()) {
//            STATE_ONLINE -> AnalyticsConstants.ONLINE
//            STATE_OFFLINE -> AnalyticsConstants.OFFLINE
//            STATE_EO -> AnalyticsConstants.EMERGENCY_ORDERING
//            STATE_NONE -> EMPTY_STRING
//        }
//    }

    private fun getAnalyticsStringForEmergencyOrderingState(): String {
        return EMPTY_STRING
        }
}