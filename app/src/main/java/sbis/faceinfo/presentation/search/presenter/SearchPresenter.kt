package sbis.faceinfo.presentation.search.presenter

import sbis.data.model.presentation.PersonSearch
import sbis.faceinfo.presentation.search.contracts.SearchInteractorContract
import sbis.faceinfo.presentation.search.contracts.SearchRouterContract
import sbis.faceinfo.presentation.search.contracts.SearchVmContract
import sbis.faceinfo.presentation.search.contracts.SearchVmContract.ViewModel.State
import sbis.helpers.arch.base.BasePresenter
import sbis.helpers.arch.contracts.AndroidComponent

class SearchPresenter(
    val interactor: SearchInteractorContract.Interactor,
    val router: SearchRouterContract.Router
) : BasePresenter<SearchVmContract.ViewModel>(),
    SearchVmContract.Presenter,
    SearchInteractorContract.Presenter,
    SearchRouterContract.Presenter {

    override fun attachView(viewModel: SearchVmContract.ViewModel, component: AndroidComponent) {
        super.attachView(viewModel, component)
        interactor.listener = this
    }

    override fun detachView() {
        interactor.listener = null
        super.detachView()
    }

    override fun obtainedPersons(persons: List<PersonSearch>, error: Throwable?) {
        if (error == null) {
            vm.state.value = State.DATA
            vm.searchPersons.value = persons
        } else {
            vm.state.value = State.ERROR
            vm.errorMessage.value = error.localizedMessage
        }
    }

    override fun updateSearchRequest(searchRequest: String) {
        vm.state.value = State.LOADING
        vm.searchRequest.value = searchRequest
        interactor.obtainPersons(searchRequest)
    }

    override fun onPersonSelected(person: PersonSearch) {
        router.showDetailInfo(androidComponent!!, person)
    }

    override fun onSecretLongClick() {
        router.showSettingScreen(androidComponent!!)
    }
}