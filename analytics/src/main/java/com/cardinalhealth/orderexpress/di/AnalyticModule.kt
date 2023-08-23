package com.cardinalhealth.orderexpress.di

import android.app.Application
import com.cardinalhealth.orderexpress.core.common.di.DiConstants.ADOBE
import com.cardinalhealth.orderexpress.core.common.di.DiConstants.FLURRY
import com.cardinalhealth.orderexpress.utils.analytics.AdobeAnalyticsProvider
import com.cardinalhealth.orderexpress.utils.analytics.AnalyticsHelper
import com.cardinalhealth.orderexpress.utils.analytics.FlurryAnalyticsProvider
import com.cardinalhealth.orderexpress.utils.analytics.IAnalyticsProvider
import com.cardinalhealth.orderexpress.utils.analytics.StorefrontUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AnalyticModule {

    @Provides
    @Singleton
    fun provideStorefrontUtils(): StorefrontUtils = StorefrontUtils()


    
    @Provides
    @Singleton
    fun provideAnalyticHelper(appContext: Application): AnalyticsHelper =
        AnalyticsHelper(appContext)

    @Singleton
    @Provides
    @Named(ADOBE)
    fun provideAdobeAnalytic(adobeAnalyticsProviderIml: AdobeAnalyticsProvider):
            IAnalyticsProvider = adobeAnalyticsProviderIml

    @Provides
    @Singleton
    @Named(FLURRY)
    fun provideFlurryAnalytic(flurryAnalyticsProviderIml: FlurryAnalyticsProvider):
            IAnalyticsProvider = flurryAnalyticsProviderIml
}