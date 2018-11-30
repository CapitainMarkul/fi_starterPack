package sbis.domain.network

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

class CookieManager : CookieJar {

    private var cookies = mutableMapOf<String, MutableList<Cookie>>()

    fun addCookie(url: String, cookie: Cookie) {
        val cookieList = cookies[url]
        if (cookieList == null) {
            cookies[url] = mutableListOf(cookie)
        } else {
            cookieList.clear()

            cookieList.add(cookie)
        }

    }

    override fun saveFromResponse(url: HttpUrl, cookies: MutableList<Cookie>) {
        this.cookies[url.url().host.toString()] = cookies
    }

    override fun loadForRequest(url: HttpUrl): MutableList<Cookie> {
        return cookies[url.url().host.toString()] ?: mutableListOf()
    }
}