package sbis.domain.network.command.rpc

import okhttp3.*
import sbis.domain.network.HttpProtocol
import sbis.domain.network.command.rpc.common.RpcCommand
import java.io.IOException

class GetFullPersonInfoCommand(val personId: Int) : RpcCommand {

    private class FullInfoRequest(
        val sid: String,
        val user_id: Int
    )

    override fun execute(okHttpClient: OkHttpClient, callBack: Callback) {
        //TODO: https://1e2e499e.ngrok.io/contacts

        //TODO: Request to Server

        //FIXME: FOR LOCAL TEST
        //TODO: "https://httpbin.org/get?website=www.journaldev.com&tutorials=android"
        val url = HttpUrl.Builder()
            .scheme(HttpProtocol.HTTPS.protocolName)
            .host("httpbin.org")
            .addPathSegment("get")
            .addQueryParameter("website", "www.journaldev.com")
            .addQueryParameter("tutorials", "android")
            .build()

        val request = Request.Builder()
            .url(url.toString())
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                callBack.onFailure(call, e)
            }

            override fun onResponse(call: Call, response: Response) {
                //FIXME: FOR LOCAL TEST
                val contentType = response.body()!!.contentType()
                val body = ResponseBody.create(contentType, generateFiveStubModels())
                callBack.onResponse(call, response.newBuilder().body(body).build())

//                callBack.onResponse(call, response)
            }
        })
    }

    private fun generateFiveStubModels() =
        "{\n" +
                "  \"user_often_leaving\": false,\n" +
                "  \"user_sociability\": 8,\n" +
                "  \"user_procrastination\": 0,\n" +
                "  \"user_responsibility\": 8,\n" +
                "  \"user_punctuality\": 6\n" +
                "}"
}