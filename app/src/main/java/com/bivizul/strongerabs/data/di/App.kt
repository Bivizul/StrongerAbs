package com.bivizul.strongerabs.data.di

import android.app.Application
import com.bivizul.strongerabs.domain.utils.Constants.ONESIGNAL_APP_ID
import com.onesignal.OneSignal
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class App : Application() {

    //TODO()
//    override fun onCreate() {
//        super.onCreate()
//
//        // Enable verbose OneSignal logging to debug issues if needed.
//        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
//
//        // OneSignal Initialization
//        OneSignal.initWithContext(this)
//        OneSignal.setAppId(ONESIGNAL_APP_ID)
//    }
}
