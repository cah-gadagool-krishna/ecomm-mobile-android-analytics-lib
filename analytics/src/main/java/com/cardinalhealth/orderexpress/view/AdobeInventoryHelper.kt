package com.cardinalhealth.orderexpress.view

import com.cardinalhealth.orderexpress.core.common.AppPageSource
import com.cardinalhealth.orderexpress.core.common.COLON
import com.cardinalhealth.orderexpress.core.common.COMMA_WITH_SPACE
import com.cardinalhealth.orderexpress.core.common.EMPTY_STRING
import com.cardinalhealth.orderexpress.utils.analytics.AnalyticsConstants
import com.cardinalhealth.orderexpress.utils.analytics.IAnalyticsProvider
import com.model.orderexpress.core.model.ScanEventModel
import com.model.orderexpress.core.model.responses.ProductSearchModel

class AdobeInventoryHelper {
    companion object {
        /**
         * Method to capture and post adobe analytics for add product in inventory location
         *
         * */
        fun captureAndPostAdobeAnalyticsForLocationDetailsPage(
            adobeAnalyticsProvider: IAnalyticsProvider,
            productSearchModel: ProductSearchModel,
            scanEventModel: ScanEventModel
        ) {
            val analyticsData = HashMap<String, String>()
            analyticsData[AnalyticsConstants.PROPERTY_C3] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getPreviousPage()

            val eventPrefix = AdobeScanHelper.getEventPrefix(
                scanEventModel.adapterViewType,
                isFromInventory = true,
                isFullCountSelected = scanEventModel.isFullCountSelected
            )
            val evarPageName: String
            if (scanEventModel.isFromScanned) {
                evarPageName = AnalyticsConstants.EVAR_INTERNAL_SCAN_RESULT
                addAnalyticsScanDetails(analyticsData, scanEventModel.scanType)
                analyticsData[AnalyticsConstants.PROPERTY_EVENTS] =
                    AnalyticsConstants.EVENT_INVENTORY_LOCATION_DETAILS + COMMA_WITH_SPACE + eventPrefix
            } else {
                evarPageName = AnalyticsConstants.EVAR_INTERNAL_SEARCH_RESULT
                addAnalyticsSearchDetails(analyticsData, scanEventModel.searchTerm)
                analyticsData[AnalyticsConstants.PROPERTY_EVENTS] =
                    AnalyticsConstants.EVENT_INVENTORY_LOCATION_DETAILS
            }

            val pageNameInfix =
                if (scanEventModel.isFromInventory && scanEventModel.isFromScanned) {
                    AnalyticsConstants.SCAN_PAGE + COLON
                } else if (scanEventModel.isFromInventory && !scanEventModel.isFromScanned) {
                    AnalyticsConstants.SEARCH_RESULT_PAGE + COLON
                } else {
                    EMPTY_STRING
                }
            analyticsData[AnalyticsConstants.PROPERTY_PAGE_NAME] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + pageNameInfix + AppPageSource.getCurrentPage()
            val evars = AdobeScanHelper.getEvarString(
                productSearchModel.stockstatusDefinition ?: EMPTY_STRING,
                pageName = evarPageName,
                position = scanEventModel.position,
                shouldExcludePositionsEvar = false
            )
            val events =
                AdobeScanHelper.getEventsStringOnAddToInventory(
                    productSearchModel,
                    scanEventModel.quantity
                )

            analyticsData[AnalyticsConstants.PROPERTY_PRODUCTS] =
                AdobeScanHelper.getProductString(productSearchModel.getCIN(), events, evars)

            adobeAnalyticsProvider.logEvent(
                AppPageSource.getCurrentPage(),
                AnalyticsConstants.EVENT_TYPE_TRACK_STATE,
                analyticsData
            )
        }

        /**
         * Method to add default analytics parameters for search
         * */
        fun addAnalyticsSearchDetails(
            analyticsData: HashMap<String, String>,
            searchTerm: String
        ) {
            analyticsData[AnalyticsConstants.PROPERTY_V60] = AnalyticsConstants.INTERNAL_SEARCH
            analyticsData[AnalyticsConstants.PROPERTY_V4] =
                AnalyticsConstants.D_EQUAL_TO + AnalyticsConstants.PROPERTY_C4
            analyticsData[AnalyticsConstants.PROPERTY_V6] =
                AnalyticsConstants.CATALOG_SEARCH_BOX_MANUAL
            analyticsData[AnalyticsConstants.PROPERTY_C4] = searchTerm
        }

        /**
         * Method to add default analytics parameters for scan
         * */
        fun addAnalyticsScanDetails(
            analyticsData: HashMap<String, String>,
            scanType: String
        ) {
            analyticsData[AnalyticsConstants.PROPERTY_V60] = AnalyticsConstants.INTERNAL_SCAN
            analyticsData[AnalyticsConstants.PROPERTY_V66] = scanType
        }
    }
}