package com.cardinalhealth.orderexpress.view

import com.cardinalhealth.orderexpress.core.common.AppPageSource
import com.cardinalhealth.orderexpress.utils.analytics.AnalyticsConstants
import com.cardinalhealth.orderexpress.utils.analytics.IAnalyticsProvider

class AdobeOrderDetailsHelper {
    companion object {
        /**
         * Method to capture and post adobe analytics data for order failure
         * */
        fun captureAndPostAdobeAnalyticsForOrderFailure(
            adobeAnalyticsProvider: IAnalyticsProvider,
            errorMessage: String,
            isFromOrderDetails: Boolean = false,
            isSubmitOrders: Boolean = false,
            isC2Order: Boolean = false
        ) {
            val analyticsData = HashMap<String, String>()
            analyticsData[AnalyticsConstants.PROPERTY_PAGE_NAME] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getCurrentPage()
            analyticsData[AnalyticsConstants.PROPERTY_C3] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getPreviousPage()

            val featuredLinkValue =
                getFeaturedLinkValue(isFromOrderDetails, isSubmitOrders, isC2Order)
            analyticsData[AnalyticsConstants.PROPERTY_C7] =
                AnalyticsConstants.FEATURED_LINKS + featuredLinkValue
            analyticsData[AnalyticsConstants.PROPERTY_V28] =
                AnalyticsConstants.FEATURED_LINKS + featuredLinkValue
            analyticsData[AnalyticsConstants.PROPERTY_EVENTS] = AnalyticsConstants.EVENT_36_95
            analyticsData[AnalyticsConstants.PROPERTY_V94] = errorMessage
            analyticsData[AnalyticsConstants.PROPERTY_V60] = AnalyticsConstants.ERROR_CODE

            adobeAnalyticsProvider.logEvent(
                AppPageSource.getCurrentPage(),
                AnalyticsConstants.EVENT_TYPE_TRACK_STATE,
                analyticsData
            )
        }

        private fun getFeaturedLinkValue(
            isFromOrderDetails: Boolean,
            isSubmitOrders: Boolean,
            isC2Order: Boolean
        ): String {
            return if (isC2Order) {
                if (isSubmitOrders) {
                    AnalyticsConstants.PLACE_C2_ORDER
                } else {
                    AnalyticsConstants.UPLOAD_C2_ORDER
                }
            } else {
                if (isFromOrderDetails && isSubmitOrders) {
                    AnalyticsConstants.PLACE_ORDER
                } else if (isFromOrderDetails && !isSubmitOrders) {
                    AnalyticsConstants.UPLOAD_ORDER
                } else if (!isFromOrderDetails && isSubmitOrders) {
                    AnalyticsConstants.PLACE_ALL_ORDER
                } else {
                    AnalyticsConstants.UPLOAD_ALL_ORDER
                }
            }
        }
    }
}