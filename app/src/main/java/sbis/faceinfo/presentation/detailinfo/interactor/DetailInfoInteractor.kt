package sbis.faceinfo.presentation.detailinfo.interactor

import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import sbis.data.mapper.transformToPresentation
import sbis.data.model.gson.PersonParamsGson
import sbis.domain.network.service.network.NetworkService
import sbis.faceinfo.presentation.detailinfo.contracts.DetailInfoInteractorContract
import sbis.helpers.arch.base.BaseInteractor
import java.io.IOException

class DetailInfoInteractor(private val networkService: NetworkService) :
    BaseInteractor<DetailInfoInteractorContract.Presenter>(),
    DetailInfoInteractorContract.Interactor {

    override fun obtainUserFullInfo(userId: Int) {
        networkService.getPersonFullInfo(userId, object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runUi {
                    listener?.obtainedUserFulInfo(null, e)
                }
            }

            override fun onResponse(call: Call, response: Response) {
                val resultJson = response.body()!!.string()
                try {
                    val personInfo = Gson().fromJson<PersonParamsGson>(resultJson, PersonParamsGson::class.java)
                    runUi { listener?.obtainedUserFulInfo(personInfo.transformToPresentation(), null) }
                } catch (e: Exception) {
                    listener?.obtainedUserFulInfo(null, Exception(resultJson))
                }
            }
        })
    }
}