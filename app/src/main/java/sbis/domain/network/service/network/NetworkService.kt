package sbis.domain.network.service.network

import okhttp3.Callback


interface NetworkService {
    fun getPersonFullInfo(id: Int, callBack: Callback)
    fun searchPersons(searchRequest: String, responseCallBack: Callback)
}