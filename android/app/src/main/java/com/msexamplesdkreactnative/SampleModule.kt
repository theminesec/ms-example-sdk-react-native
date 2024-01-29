package com.msexamplesdkreactnative

import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.google.gson.GsonBuilder
import com.theminesec.MineHades.MhdCPOC

class SampleModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    override fun getName(): String = "SampleModule"

    @ReactMethod
    fun initSdk() {
        val tag = "ms-example-sdk-rn"
        Log.d(tag, "activity onCreate")
        val prettyGson = GsonBuilder().setPrettyPrinting().create()
        val sdk = MhdCPOC.getInstance()
        val yourDeviceId = "client-example-123"
        val licenseFileName = "example.license"
        val initResult = sdk.MhdCPOC_Init2(reactApplicationContext, licenseFileName, yourDeviceId)

        Log.d(tag, "initSdk: ${prettyGson.toJson(initResult)}")
    }

}
