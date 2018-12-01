package sbis.domain.network.service.network

import okhttp3.Callback
import okhttp3.OkHttpClient
import sbis.domain.network.command.rpc.GetFullPersonInfoCommand

class NetworkServiceImpl(private val okHttpClient: OkHttpClient) : NetworkService {

    override fun getPersonFullInfo(id: Int, callBack: Callback) =
        GetFullPersonInfoCommand(id).execute(okHttpClient, callBack)
}