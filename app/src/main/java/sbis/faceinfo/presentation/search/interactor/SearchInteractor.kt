package sbis.faceinfo.presentation.search.interactor

import sbis.domain.network.service.network.NetworkService
import sbis.faceinfo.presentation.search.contracts.SearchInteractorContract
import sbis.helpers.arch.base.BaseInteractor

class SearchInteractor(private val networkService: NetworkService) :
    BaseInteractor<SearchInteractorContract.Presenter>(),
    SearchInteractorContract.Interactor {

    override fun obtainPersons(searchRequest: String) {
//        TODO: networkService.searchPersons(searchRequest, object : Callback { ... }
//        runUI {  }
//        listener?.obtainedPersons(emptyList(), e)
        /*
        * val resultJson = response.body()!!.string()
        * val type = object : TypeToken<List<PersonSearchGson>>() {}.type
        * val persons = Gson().fromJson<List<PersonSearchGson>>(resultJson, type)
        * */
//        Не забыть try/catch - т.к. может придти невалидный Json
    }
}