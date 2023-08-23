package com.cardinalhealth.orderexpress.view

import com.cardinalhealth.orderexpress.core.common.AdapterViewType
import com.cardinalhealth.orderexpress.core.common.AppPageSource
import com.cardinalhealth.orderexpress.core.common.COLON
import com.cardinalhealth.orderexpress.core.common.COMMA_SEPARATOR
import com.cardinalhealth.orderexpress.core.common.COMMA_WITH_SPACE
import com.cardinalhealth.orderexpress.core.common.EMPTY_STRING
import com.cardinalhealth.orderexpress.core.common.EMPTY_STRING_WITH_SINGLE_SPACE
import com.cardinalhealth.orderexpress.core.common.EQUAL
import com.cardinalhealth.orderexpress.core.common.HYPHEN
import com.cardinalhealth.orderexpress.core.common.L_BAR
import com.cardinalhealth.orderexpress.core.common.NEW_DATE_FORMAT
import com.cardinalhealth.orderexpress.core.common.NINE
import com.cardinalhealth.orderexpress.core.common.ONE
import com.cardinalhealth.orderexpress.core.common.SEMI_COLON
import com.cardinalhealth.orderexpress.core.common.STRING_ZERO
import com.cardinalhealth.orderexpress.core.common.ZERO
import com.cardinalhealth.orderexpress.utils.analytics.AnalyticsConstants
import com.cardinalhealth.orderexpress.utils.analytics.IAnalyticsProvider
import com.model.orderexpress.core.model.ScanEventModel
import com.model.orderexpress.core.model.responses.ProductSearchModel
import com.model.orderexpress.core.model.responses.ReceivingSearchItem
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AdobeScanHelper {
    companion object {
        /**
         * Method to capture adobe analytics for global scan
         * */
        fun sendScanLandingEvent(adobeAnalyticsProvider: IAnalyticsProvider) {
            val analyticsData = HashMap<String, String>()
            captureAndPostAnalyticsData(analyticsData, adobeAnalyticsProvider)
        }

        /**
         * Method to capture and post analytics events for scan error
         * */
        fun sendErrorInfoScanEvent(
            adobeAnalyticsProvider: IAnalyticsProvider,
            adapterViewType: AdapterViewType,
            isFromInventory: Boolean,
            isFullCountSelected: Boolean,
            scanType: String = EMPTY_STRING
        ) {
            val analyticsData = HashMap<String, String>()
            val eventsPrefix = getEventPrefix(adapterViewType, isFromInventory, isFullCountSelected)

            val events = if (eventsPrefix.isEmpty()) {
                AnalyticsConstants.EVENT_5_88
            } else {
                AnalyticsConstants.EVENT_5_88
                    .plus(COMMA_WITH_SPACE)
                    .plus(eventsPrefix)
            }

            analyticsData[AnalyticsConstants.PROPERTY_EVENTS] = events

            if (scanType.isNotEmpty()) {
                analyticsData[AnalyticsConstants.PROPERTY_V66] = scanType
            }

            val searchOrScanString = when (adapterViewType) {
                AdapterViewType.IS_FROM_SCAN -> {
                    AnalyticsConstants.LOWER_CASE_SCAN
                }
                AdapterViewType.IS_FROM_SCAN_ORDERING -> {
                    AnalyticsConstants.ORDERING_SCAN
                }
                AdapterViewType.IS_FROM_SCAN_PRICE_CHECK -> {
                    AnalyticsConstants.PRICE_CHECK_SCAN
                }
                else -> {
                    AnalyticsConstants.LOWER_CASE_SEARCH
                }
            }
            val featuredLinksString = populateFeaturedLinksString(ZERO, searchOrScanString)

            // HAT-8057 : Adding featuredLinks for c7 and v28 properties
            analyticsData[AnalyticsConstants.PROPERTY_C7] = featuredLinksString
            analyticsData[AnalyticsConstants.PROPERTY_V28] = featuredLinksString

            captureAndPostAnalyticsData(analyticsData, adobeAnalyticsProvider)
        }

        fun getEventPrefix(
            adapterViewType: AdapterViewType,
            isFromInventory: Boolean,
            isFullCountSelected: Boolean
        ): String {
            return when (adapterViewType) {
                AdapterViewType.IS_FROM_SCAN_ORDERING -> {
                    AnalyticsConstants.EVENT_97
                }
                AdapterViewType.IS_FROM_SCAN_PRICE_CHECK -> {
                    AnalyticsConstants.EVENT_96
                }
                else -> {
                    if (isFromInventory) {
                        if (isFullCountSelected) {
                            AnalyticsConstants.EVENT_98
                        } else {
                            AnalyticsConstants.EVENT_99
                        }
                    } else {
                        EMPTY_STRING
                    }
                }
            }
        }

        /**
         * Method to send successful scan event
         * */
        fun sendSuccessfulScanEvent(
            adobeAnalyticsProvider: IAnalyticsProvider,
            scanEventModel: ScanEventModel
        ) {
            val analyticsData = HashMap<String, String>()
            val eventPrefix = getEventPrefix(
                scanEventModel.adapterViewType,
                scanEventModel.isFromInventory,
                scanEventModel.isFullCountSelected
            )

            var events = if (scanEventModel.isAlternateProduct) {
                AnalyticsConstants.EVENT_14_72
            } else {
                AnalyticsConstants.EVENT_4_86
            }

            if (eventPrefix.isNotEmpty()) {
                events += COMMA_WITH_SPACE + eventPrefix
            }

            if (scanEventModel.isAlternateProduct) {
                analyticsData[AnalyticsConstants.PROPERTY_C7] =
                    AnalyticsConstants.FEATURED_LINKS + AnalyticsConstants.SEARCH_RESULTS_ALT
                analyticsData[AnalyticsConstants.PROPERTY_V28] =
                    AnalyticsConstants.FEATURED_LINKS + AnalyticsConstants.SEARCH_RESULTS_ALT
            }

            analyticsData[AnalyticsConstants.PROPERTY_EVENTS] = events
            analyticsData[AnalyticsConstants.PROPERTY_PAGE_NAME] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getCurrentPage()
            analyticsData[AnalyticsConstants.PROPERTY_C3] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getPreviousPage()

            val evars = if (scanEventModel.isAlternateProduct) {
                getEvarString(
                    scanEventModel.stockStatusDefinition,
                    pageName = AnalyticsConstants.EVAR_ALTERNATE_SUGGESTION_SCAN_RESULTS
                )
            } else {
                getEvarString(
                    scanEventModel.stockStatusDefinition,
                    pageName = AnalyticsConstants.EVAR_INTERNAL_SCAN_RESULT
                )
            }

            val productString = if (scanEventModel.productsString.isEmpty()) {
                getProductString(scanEventModel.cin, EMPTY_STRING, evars)
            } else {
                scanEventModel.productsString
            }
            analyticsData[AnalyticsConstants.PROPERTY_PRODUCTS] = productString

            if (scanEventModel.scanType.isNotEmpty()) {
                analyticsData[AnalyticsConstants.PROPERTY_V66] = scanEventModel.scanType
            }

            analyticsData[AnalyticsConstants.PROPERTY_V60] =
                if (scanEventModel.isAlternateProduct) {
                    AnalyticsConstants.NAVIGATED
                } else {
                    AnalyticsConstants.INTERNAL_SCAN
                }

            val searchOrScanString = when (scanEventModel.adapterViewType) {
                AdapterViewType.IS_FROM_SCAN -> {
                    AnalyticsConstants.LOWER_CASE_SCAN
                }
                AdapterViewType.IS_FROM_SCAN_ORDERING -> {
                    AnalyticsConstants.ORDERING_SCAN
                }
                AdapterViewType.IS_FROM_SCAN_PRICE_CHECK -> {
                    AnalyticsConstants.PRICE_CHECK_SCAN
                }
                else -> {
                    AnalyticsConstants.LOWER_CASE_SEARCH
                }
            }
            // Sending ONE as ideally only 1 result is fetched for a successful scan
            val featuredLinksString = populateFeaturedLinksString(ONE, searchOrScanString)

            // HAT-8057 : Adding featuredLinks for c7 and v28 properties
            analyticsData[AnalyticsConstants.PROPERTY_C7] = featuredLinksString
            analyticsData[AnalyticsConstants.PROPERTY_V28] = featuredLinksString

            postAdobeAnalyticsData(adobeAnalyticsProvider, analyticsData)
        }

        /**
         * Method to send successful search event
         * */
        fun sendSearchEvent(
            adobeAnalyticsProvider: IAnalyticsProvider,
            itemList: List<ProductSearchModel> = emptyList(),
            searchedText: String
        ) {
            val analyticsData = HashMap<String, String>()
            var productString = EMPTY_STRING
            itemList.forEachIndexed { index, element ->
                if (index <= NINE) {
                    val evars = element.stockstatusDefinition?.let {
                        element.isEligible?.let { isEligible ->
                            getEvarString(
                                it,
                                pageName = AnalyticsConstants.EVAR_INTERNAL_SEARCH_RESULT,
                                position = index + ONE,
                                isFromSearch = true,
                                isEligible = isEligible
                            )
                        }
                    }
                    productString += element.cin?.let {
                        evars?.let { it1 ->
                            getProductString(
                                it,
                                EMPTY_STRING,
                                it1
                            )
                        }
                    }.toString()
                    productString += COMMA_SEPARATOR
                }
                if (index == NINE) {
                    return@forEachIndexed
                }
            }
            val featuredLinksString = populateFeaturedLinksString(itemList.size)

            // HAT-8057 : Adding featuredLinks for c7 and v28 properties
            analyticsData[AnalyticsConstants.PROPERTY_C7] = featuredLinksString
            analyticsData[AnalyticsConstants.PROPERTY_V28] = featuredLinksString

            populateGenericSearchProperties(
                analyticsData,
                searchedText,
                itemList.size,
                productString
            )
            postAdobeAnalyticsData(adobeAnalyticsProvider, analyticsData)
        }

        /**
         * Populate featuredLinks string required for c7 and v28
         * (Implemented as part of HAT-8057)
         *
         * @param itemListCount Size of list of products for search/Scan result used to determine 0 or emptyString in resultant string
         * @param searchOrScanString Search/Scan String for featured Links, Default is "search"
         */
        fun populateFeaturedLinksString(
            itemListCount: Int,
            searchOrScanString: String = AnalyticsConstants.LOWER_CASE_SEARCH
        ): String {
            val zeroString = if (itemListCount == ZERO) {
                STRING_ZERO + EMPTY_STRING_WITH_SINGLE_SPACE
            } else {
                EMPTY_STRING
            }

            return AnalyticsConstants.FEATURED_LINKS + AppPageSource.getPreviousPage() + HYPHEN + AppPageSource.getCurrentPage() + HYPHEN + AnalyticsConstants.CLICKED + EMPTY_STRING_WITH_SINGLE_SPACE + zeroString + searchOrScanString
        }

        /**
         * Method to capture and send analytics data for receiving search
         * */
        fun sendSearchEventForReceiving(
            adobeAnalyticsProvider: IAnalyticsProvider,
            itemList: List<ReceivingSearchItem> = emptyList(),
            searchedText: String
        ) {
            val analyticsData = HashMap<String, String>()
            var productString = EMPTY_STRING
            itemList.forEachIndexed { index, element ->
                if (index <= NINE) {
                    val evars = getEvarString(
                        EMPTY_STRING,
                        pageName = AnalyticsConstants.EVAR_INTERNAL_SEARCH_RESULT,
                        position = index + ONE
                    )

                    productString += element.receivingToteItemList[0].cin?.let {
                        getProductString(
                            it,
                            EMPTY_STRING,
                            evars
                        )
                    }.toString()
                    productString += COMMA_SEPARATOR
                }
                if (index == NINE) {
                    return@forEachIndexed
                }
            }
            populateGenericSearchProperties(
                analyticsData,
                searchedText,
                itemList.size,
                productString
            )
            postAdobeAnalyticsData(adobeAnalyticsProvider, analyticsData)
        }

        /**
         * Method to send event after successful click on alternate from search
         * */
        fun sendSearchAlternateEvent(
            adobeAnalyticsProvider: IAnalyticsProvider,
            alternateProduct: ProductSearchModel,
            actualProduct: ProductSearchModel?
        ) {
            val analyticsData = HashMap<String, String>()
            analyticsData.clear()
            analyticsData[AnalyticsConstants.PROPERTY_PAGE_NAME] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getCurrentPage()

            analyticsData[AnalyticsConstants.PROPERTY_EVENTS] =
                AnalyticsConstants.EVENT_14_PROD_VIEW_72

            val alternateEvars = AnalyticsConstants.EVAR_23 +
                    AnalyticsConstants.EVAR_ALTERNATE_SUGGESTION_SEARCH_RESULTS +
                    L_BAR + AnalyticsConstants.EVAR_33 + alternateProduct.stockstatusDefinition

            val actualEvars = AnalyticsConstants.EVAR_23 +
                    AnalyticsConstants.REFERRRING_ALTERNATE_PRODUCT_SEARCH_RESULT +
                    L_BAR + AnalyticsConstants.EVAR_33 + actualProduct?.stockstatusDefinition

            val productString = actualProduct?.getCIN()?.let {
                getProductString(
                    it,
                    EMPTY_STRING,
                    alternateEvars
                )
            } + COMMA_SEPARATOR + getProductString(
                alternateProduct.getCIN(),
                EMPTY_STRING,
                actualEvars
            )

            analyticsData[AnalyticsConstants.PROPERTY_PRODUCTS] = productString

            analyticsData[AnalyticsConstants.PROPERTY_C7] =
                AnalyticsConstants.FEATURED_LINKS + AnalyticsConstants.SEARCH_RESULTS_ALT

            analyticsData[AnalyticsConstants.PROPERTY_V28] =
                AnalyticsConstants.FEATURED_LINKS + AnalyticsConstants.SEARCH_RESULTS_ALT

            analyticsData[AnalyticsConstants.PROPERTY_C3] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getPreviousPage()

            analyticsData[AnalyticsConstants.PROPERTY_V60] =
                AnalyticsConstants.NAVIGATED

            postAdobeAnalyticsData(adobeAnalyticsProvider, analyticsData)
        }

        /**
         * Method to get the evar String for analytics
         * */
        fun getEvarString(
            stockDefinition: String = EMPTY_STRING,
            pageNumber: Int = ONE,
            position: Int = ONE,
            pageName: String = EMPTY_STRING,
            shouldExcludePositionsEvar: Boolean = false,
            isFromSearch: Boolean = false,
            isEligible: String = EMPTY_STRING
        ): String {
            return AnalyticsConstants.EVAR_23 +
                    pageName +
                    if (stockDefinition.isNotEmpty()) {
                        L_BAR + AnalyticsConstants.EVAR_33 + stockDefinition
                    } else {
                        EMPTY_STRING
                    } +
                    if (shouldExcludePositionsEvar) {
                        EMPTY_STRING
                    } else {
                        L_BAR + AnalyticsConstants.EVAR_9 + pageNumber + COLON + position
                    } +
                    if (pageName == AnalyticsConstants.EVAR_UPLOAD_ORDER || pageName == AnalyticsConstants.EVAR_UPLOAD_ALL_ORDER
                        || pageName == AnalyticsConstants.EVAR_PLACE_ORDER || pageName == AnalyticsConstants.EVAR_PLACE_ALL_ORDER
                    ) {
                        L_BAR + AnalyticsConstants.EVAR_19 + getCurrentDate()
                    } else {
                        EMPTY_STRING
                    } +
                    if (isFromSearch && isEligible.isNotEmpty()) {
                        L_BAR + AnalyticsConstants.EVAR_45 + isEligible
                    } else {
                        EMPTY_STRING
                    }
        }

        fun concatenateStringWithLBar(evarMap: HashMap<String, String>): String {
            evarMap.size
            var evars = EMPTY_STRING
            var count = ZERO
            evarMap.forEach {
                count++
                evars += it.key + it.value + if (count < evarMap.size) {
                    L_BAR
                } else {
                    EMPTY_STRING
                }
            }
            return evars
        }

        fun getEventsStringOnAddToOrder(
            productSearchModel: ProductSearchModel,
            quantity: Int = ZERO
        ): String {
            return getEventsString(
                quantity.toString(),
                productSearchModel,
                AnalyticsConstants.EVENT_15,
                AnalyticsConstants.EVENT_16
            )
        }

        fun getEventsStringOnAddToInventory(
            productSearchModel: ProductSearchModel,
            quantity: String = STRING_ZERO
        ): String {
            return getEventsString(
                quantity,
                productSearchModel,
                AnalyticsConstants.EVENT_108,
                AnalyticsConstants.EVENT_109
            )
        }

        fun getEvarsStringOnAddToOrder(
            productSearchModel: ProductSearchModel,
            isFromScanned: Boolean = false,
            isAlternateProduct: Boolean = false,
            clientOrderId: String
        ): String {
            val evarMap = HashMap<String, String>()
            evarMap[AnalyticsConstants.EVAR_19] = getCurrentDate()
            evarMap[AnalyticsConstants.EVAR_23] = if (isAlternateProduct) {
                if (isFromScanned) {
                    AnalyticsConstants.EVAR_ALTERNATE_SUGGESTION_SCAN_RESULTS
                } else {
                    AnalyticsConstants.EVAR_ALTERNATE_SUGGESTION_SEARCH_RESULTS
                }
            } else {
                if (isFromScanned) {
                    AnalyticsConstants.EVAR_INTERNAL_SCAN_RESULT
                } else {
                    AnalyticsConstants.EVAR_INTERNAL_SEARCH_RESULT
                }
            }
            evarMap[AnalyticsConstants.EVAR_33] =
                productSearchModel.stockstatusDefinition ?: EMPTY_STRING

            evarMap[AnalyticsConstants.EVAR_22] =
                productSearchModel.productType.toString()

            evarMap[AnalyticsConstants.EVAR_49] = clientOrderId

            if (!isAlternateProduct) {
                evarMap[AnalyticsConstants.EVAR_9] = AnalyticsConstants.DEFAULT_PAGE_POSITION
            }
            return concatenateStringWithLBar(evarMap)
        }

        /**
         * Method to get the Product String for analytics
         * */
        fun getProductString(
            cin: String = EMPTY_STRING,
            event: String = EMPTY_STRING,
            evars: String = EMPTY_STRING
        ): String {
            return SEMI_COLON + cin + SEMI_COLON + EMPTY_STRING + SEMI_COLON + EMPTY_STRING + SEMI_COLON + event + SEMI_COLON + evars
        }

        /**
         * Method to get the Product String for Submit Success analytics
         * */
        fun getProductStringForSubmitSuccess(
            cin: String = EMPTY_STRING,
            quantity: Int,
            invoiceCost: String,
            event: String = EMPTY_STRING,
            evars: String = EMPTY_STRING
        ): String {
            return SEMI_COLON + cin + SEMI_COLON + quantity.toString() + SEMI_COLON + invoiceCost + SEMI_COLON + event + SEMI_COLON + evars
        }

        fun getCurrentDate(): String {
            val formatter = SimpleDateFormat(NEW_DATE_FORMAT, Locale.US)
            return formatter.format(Date())
        }

        private fun postAdobeAnalyticsData(
            adobeAnalyticsProvider: IAnalyticsProvider,
            analyticsData: HashMap<String, String>
        ) {
            adobeAnalyticsProvider.logEvent(
                AppPageSource.getCurrentPage(),
                AnalyticsConstants.EVENT_TYPE_TRACK_STATE,
                analyticsData
            )
        }

        private fun captureAndPostAnalyticsData(
            analyticsData: HashMap<String, String>,
            adobeAnalyticsProvider: IAnalyticsProvider
        ) {
            analyticsData[AnalyticsConstants.PROPERTY_C3] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getPreviousPage()
            analyticsData[AnalyticsConstants.PROPERTY_V60] = AnalyticsConstants.NAVIGATED
            postAdobeAnalyticsData(adobeAnalyticsProvider, analyticsData)
        }

        /**
         * Method to populate generic data for search
         * */
        private fun populateGenericSearchProperties(
            analyticsData: HashMap<String, String>,
            searchedText: String,
            listSize: Int,
            productString: String
        ) {
            analyticsData[AnalyticsConstants.PROPERTY_PAGE_NAME] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getCurrentPage()
            analyticsData[AnalyticsConstants.PROPERTY_C4] = searchedText

            analyticsData[AnalyticsConstants.PROPERTY_V4] =
                AnalyticsConstants.D_EQUAL_TO + AnalyticsConstants.PROPERTY_C4

            analyticsData[AnalyticsConstants.PROPERTY_V6] =
                AnalyticsConstants.CATALOG_SEARCH_BOX_MANUAL

            if (productString.isNotEmpty()) {
                val productStringValue = productString.substring(ZERO, productString.length - ONE)
                analyticsData[AnalyticsConstants.PROPERTY_PRODUCTS] = productStringValue
            }

            if (listSize > ZERO) {
                analyticsData[AnalyticsConstants.PROPERTY_EVENTS] =
                    AnalyticsConstants.EVENT_4_PROD_VIEW
            } else {
                analyticsData[AnalyticsConstants.PROPERTY_EVENTS] = AnalyticsConstants.EVENT_5
            }

            analyticsData[AnalyticsConstants.PROPERTY_C3] =
                AnalyticsConstants.KEY_CAH_OE_MOBILE + AppPageSource.getPreviousPage()

            analyticsData[AnalyticsConstants.PROPERTY_V60] =
                AnalyticsConstants.INTERNAL_SEARCH
        }

        private fun getEventsString(
            quantity: String,
            productSearchModel: ProductSearchModel,
            eventOne: String,
            eventTwo: String
        ): String {
            val eventsMap = HashMap<String, String>()
            eventsMap[eventOne] = EQUAL + quantity
            eventsMap[eventTwo] = EQUAL + productSearchModel.invoiceCost.toString()
            return concatenateStringWithLBar(eventsMap)
        }
    }
}