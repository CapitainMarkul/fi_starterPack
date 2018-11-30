package sbis.domain.repository.storage

import android.content.Context
import sbis.App
import sbis.domain.network.HttpProtocol

class StorageServiceImpl(val context: Context) : StorageService {

    companion object {
        const val KEY_STORAGE_NAME = "FACE_INFO_SHARED_PREF"

        const val KEY_SERVER_URL = "KEY_SERVER_URL"
        const val KEY_USER_SID = "KEY_USER_SID"
    }

    private val sharedPreferences by lazy {
        context.getSharedPreferences(KEY_STORAGE_NAME, Context.MODE_PRIVATE)
    }

    override fun saveServerUrl(serverUrl: String) =
        sharedPreferences.edit().putString(KEY_SERVER_URL, serverUrl).apply()

    override fun getServerUrl(): String =
        sharedPreferences.getString(KEY_SERVER_URL, "")

    override fun getFullServerUrl() =
        String.format("{0}://{1}", HttpProtocol.HTTP, sharedPreferences.getString(KEY_SERVER_URL, ""))

    override fun saveUserSid(userSid: String) {
        sharedPreferences.edit().putString(KEY_USER_SID, userSid).apply()

        App.get().updateCookieSid()
    }

    override fun getUserSid(): String =
        sharedPreferences.getString(KEY_USER_SID, "")
}