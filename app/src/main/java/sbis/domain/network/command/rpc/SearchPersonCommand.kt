package sbis.domain.network.command.rpc

import okhttp3.*
import sbis.domain.network.HttpProtocol
import sbis.domain.network.command.rpc.common.RpcCommand
import java.io.IOException

class SearchPersonCommand(private val searchRequest: String) : RpcCommand {

    private class SearchRequest(
        val sid: String,
        val query_str: String
    )

    override fun execute(okHttpClient: OkHttpClient, callBack: Callback) {
        //TODO: https://1e2e499e.ngrok.io/contacts

//        val requestJson = Gson().toJson(
//            SearchRequest(
//                sid = App.get().getStorageService().getUserSid(),
//                query_str = searchRequest
//            )
//        )
//
//        val url = HttpUrl.Builder()
//            .scheme(HttpProtocol.HTTPS.protocolName)
//            .host(App.get().getStorageService().getServerUrl())
//            .addPathSegment("contacts")
//            .build()
//
//        val requestBody = RequestBody.create(MediaType.parse("application/json"), requestJson)
//
//        val request = Request.Builder()
//            .url(url.toString())
//            .post(requestBody)
//            .build()

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
        "[\n" +
                "  {\n" +
                "    \"id\": 21548521,\n" +
                "    \"name\": \"Алексей\",\n" +
                "    \"photoUrl\": \"https://online.sbis.ru/service/?id=3&method=PrivateFace.GetPhoto&protocol=5&params=eyJQaG90b0lkIjo5MTY4NiwiU2l6ZSI6NDB9\",\n" +
                "    \"postName\": \"Филиал в Костроме\",\n" +
                "    \"secondName\": \"Барган\"\n" +
                "  }\n" +
                "]"
}