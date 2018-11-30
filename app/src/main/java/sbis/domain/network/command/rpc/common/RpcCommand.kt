package sbis.domain.network.command.rpc.common

import okhttp3.Callback
import okhttp3.OkHttpClient

interface RpcCommand {
    fun execute(okHttpClient: OkHttpClient, callBack: Callback)
}