package com.cardinalhealth.orderexpress.view

import com.cardinalhealth.orderexpress.core.common.EMPTY_STRING
import com.cardinalhealth.orderexpress.utils.analytics.AnalyticsConstants
import com.model.orderexpress.core.model.responses.ProductSearchModel

/**
 * Helper class for dashboard adobe analytics
 * */
class AdobeDashboardHelper {
    companion object {
        /**
         * Method to get the productString for the dashboard components
         * */
        fun getProductString(
            productSearchModel: ProductSearchModel
        ): String {
            val evars = AdobeScanHelper.getEvarString(
                stockDefinition = productSearchModel.stockstatusDefinition ?: EMPTY_STRING,
                pageName = AnalyticsConstants.EVAR_DASHBOARD,
                shouldExcludePositionsEvar = true,
                isFromSearch = true,
                isEligible = productSearchModel.isEligible ?: EMPTY_STRING
            )
            return AdobeScanHelper.getProductString(
                productSearchModel.getCIN(),
                EMPTY_STRING,
                evars
            )
        }
    }
}