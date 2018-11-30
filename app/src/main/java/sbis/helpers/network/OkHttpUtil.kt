package sbis.helpers.network

import android.util.Log
import okhttp3.OkHttpClient

fun OkHttpClient.cancelAllCalls() {
    try {
        dispatcher().queuedCalls().forEach {
            it.cancel()
        }

        dispatcher().runningCalls().forEach {
            it.cancel()
        }
    } catch (e: Exception) {
        Log.e("TAG", e.toString())
    }
}