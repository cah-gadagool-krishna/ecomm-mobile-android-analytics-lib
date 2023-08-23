package com.cardinalhealth.orderexpress.utils.analytics

import android.app.Application
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AnalyticsHelper constructor(val context: Application) {
    fun getMappingList(): List<AnalyticsMap> {
        return Gson().fromJson(
            readJson(),
            object : TypeToken<List<AnalyticsMap>>() {}.type
        )
    }

    private fun readJson(): String {
        return context.assets.open(AnalyticsConstants.MAPPING_FILE).bufferedReader().use {
            it.readText()
        }
    }
}