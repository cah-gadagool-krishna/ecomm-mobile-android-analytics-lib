package com.cardinalhealth.orderexpress.utils.analytics

import com.cardinalhealth.orderexpress.core.common.AppPageSource
import com.cardinalhealth.orderexpress.utils.analytics.AnalyticsConstants.Companion.HOME

/**
 * Class used for Analytics related Utils
 */
class AnalyticsUtils {

    companion object {
        //Used to get the class name where the search is been called
        var classNameForAnalytics = HOME
        private val analyticsData = HashMap<String, String>()

        /**
         * Method to capture the data for analytics whenever user clicks on Add Location button
         */
        fun captureAndPostAnalyticsDataForAddLocationClick(adobeAnalyticsProvider: IAnalyticsProvider) {
            analyticsData.clear()

            analyticsData[AnalyticsConstants.PROPERTY_PAGE_NAME] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getCurrentPage()

            analyticsData[AnalyticsConstants.PROPERTY_V1] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getCurrentPage()

            if (AppPageSource.getPreviousPage().isEmpty()) {
                analyticsData[AnalyticsConstants.PROPERTY_C3] =
                    AnalyticsConstants.KEY_CAH_OE_MOBILE + AnalyticsConstants.DASHBOARD_PAGE
            } else {
                analyticsData[AnalyticsConstants.PROPERTY_C3] =
                    AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getPreviousPage()
            }

            analyticsData[AnalyticsConstants.PROPERTY_EVENTS] =
                AnalyticsConstants.EVENT_36_112

            analyticsData[AnalyticsConstants.PROPERTY_C7] =
                AnalyticsConstants.CIM_ADD_LOCATION

            analyticsData[AnalyticsConstants.PROPERTY_V28] =
                AnalyticsConstants.CIM_ADD_LOCATION

            analyticsData[AnalyticsConstants.PROPERTY_EVENTS] =
                AnalyticsConstants.EVENT_36

            adobeAnalyticsProvider.logEvent(
                AppPageSource.getCurrentPage(),
                AnalyticsConstants.EVENT_TYPE_TRACK_ACTION,
                analyticsData
            )
        }

        fun captureC2andNonC2OrderTabAnalyticsData(
            adobeAnalyticsProvider: IAnalyticsProvider,
            featureLink: String,
            v18: String
        ) {
            analyticsData.clear()

            analyticsData[AnalyticsConstants.PROPERTY_PAGE_NAME] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getCurrentPage()

            analyticsData[AnalyticsConstants.PROPERTY_V1] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getCurrentPage()

            analyticsData[AnalyticsConstants.PROPERTY_V2] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getPreviousPage()

            analyticsData[AnalyticsConstants.PROPERTY_C3] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getPreviousPage()

            analyticsData[AnalyticsConstants.PROPERTY_C7] =
                AnalyticsConstants.FEATURED_LINKS + featureLink

            analyticsData[AnalyticsConstants.PROPERTY_V28] =
                AnalyticsConstants.FEATURED_LINKS + featureLink

            analyticsData[AnalyticsConstants.PROPERTY_V18] = v18

            analyticsData[AnalyticsConstants.PROPERTY_EVENTS] =
                AnalyticsConstants.EVENT_36

            adobeAnalyticsProvider.logEvent(
                AppPageSource.getCurrentPage(),
                AnalyticsConstants.EVENT_TYPE_TRACK_ACTION,
                analyticsData
            )
        }

        fun captureSignAndPlaceOrderConfirmation(adobeAnalyticsProvider: IAnalyticsProvider) {
            analyticsData.clear()

            analyticsData[AnalyticsConstants.PROPERTY_PAGE_NAME] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getCurrentPage()

            analyticsData[AnalyticsConstants.PROPERTY_V1] =
                AnalyticsConstants.D_EQUAL_TO + AnalyticsConstants.PROPERTY_PAGE_NAME

            analyticsData[AnalyticsConstants.PROPERTY_V2] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getPreviousPage()

            analyticsData[AnalyticsConstants.PROPERTY_C3] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getPreviousPage()

            analyticsData[AnalyticsConstants.PROPERTY_V60] = AnalyticsConstants.NAVIGATED

            adobeAnalyticsProvider.logEvent(
                AppPageSource.getCurrentPage(),
                AnalyticsConstants.EVENT_TYPE_TRACK_ACTION,
                analyticsData
            )
        }

        fun captureOnOrderPageLoad(
            adobeAnalyticsProvider: IAnalyticsProvider,
            pageName: String
        ) {
            analyticsData.clear()

            analyticsData[AnalyticsConstants.PROPERTY_PAGE_NAME] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + pageName

            analyticsData[AnalyticsConstants.PROPERTY_V1] =
                AnalyticsConstants.D_EQUAL_TO + AnalyticsConstants.PROPERTY_PAGE_NAME

            analyticsData[AnalyticsConstants.PROPERTY_V2] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getPreviousPage()

            if (AppPageSource.getPreviousPage().isEmpty()) {
                analyticsData[AnalyticsConstants.PROPERTY_C3] =
                    AnalyticsConstants.KEY_CAH_OE_MOBILE + AnalyticsConstants.DASHBOARD_PAGE
            } else {
                analyticsData[AnalyticsConstants.PROPERTY_C3] =
                    AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getPreviousPage()
            }

            analyticsData[AnalyticsConstants.PROPERTY_V60] = AnalyticsConstants.NAVIGATED

            adobeAnalyticsProvider.logEvent(
                AppPageSource.getCurrentPage(),
                AnalyticsConstants.EVENT_TYPE_TRACK_ACTION,
                analyticsData
            )
        }
    }
}