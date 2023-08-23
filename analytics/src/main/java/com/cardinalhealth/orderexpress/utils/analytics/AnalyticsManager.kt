package com.cardinalhealth.orderexpress.utils.analytics

import android.app.Application
import android.util.Log
import com.adobe.marketing.mobile.Analytics
import com.adobe.marketing.mobile.Identity
import com.adobe.marketing.mobile.LoggingMode
import com.adobe.marketing.mobile.MobileCore
import com.cardinalhealth.orderexpress.core.common.EMPTY_STRING
import com.cardinalhealth.orderexpress.core.common.buildConfig.BuildConfigValues
import com.flurry.android.FlurryAgent
import timber.log.Timber
/**
 * This class handles initialization of all analytics library
 */
class AnalyticsManager constructor(
    val application: Application,
) {
    init {
        initializeAdobeAnalytics()
        initializeFlurryAnalytics()
    }

    private fun initializeFlurryAnalytics() {
        FlurryAgent.Builder()
            .withLogEnabled(true)
            .withLogLevel(Log.INFO)
            .withCaptureUncaughtExceptions(true)
            .withContinueSessionMillis(10000)
            .build(application.applicationContext, BuildConfigValues.FLURRY_KEY)

        FlurryAgent.setVersionName(BuildConfigValues.VERSION_NAME)
        Timber.d("Initialized Flurry")
        FlurryAgent.onStartSession(application.applicationContext)
    }

    private fun initializeAdobeAnalytics() {
        MobileCore.setApplication(application)
        MobileCore.setLogLevel(LoggingMode.DEBUG)
        MobileCore.configureWithAppID(BuildConfigValues.ADOBE_KEY)
        try {
            Analytics.registerExtension()//Register Analytics with Mobile Core
            Identity.registerExtension()
            Identity.getExperienceCloudId {
                mid = it
            }
            MobileCore.start(null)
            Timber.d("Initialized Adobe Analytics")
        } catch (e: Exception) {
            Timber.d(e.message)
        }
    }

    companion object {
        var mid = EMPTY_STRING
    }
}