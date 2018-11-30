package sbis.faceinfo.presentation.search.viewModel

import android.arch.lifecycle.MutableLiveData
import sbis.data.model.presentation.PersonSearch
import sbis.faceinfo.presentation.search.contracts.SearchVmContract
import sbis.faceinfo.presentation.search.contracts.SearchVmContract.ViewModel.State
import sbis.helpers.arch.base.BaseViewModel

class SearchViewModel() : BaseViewModel(), SearchVmContract.ViewModel {
    override var state = MutableLiveData<State>().apply { value = State.INITIAL }
    override var errorMessage = MutableLiveData<String?>().apply { value = null }
    override var searchRequest = MutableLiveData<String>().apply { value = "" }
    override var searchPersons = MutableLiveData<List<PersonSearch>>().apply { value = emptyList() }
}