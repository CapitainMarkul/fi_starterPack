package sbis.faceinfo.presentation.search.contracts

import android.arch.lifecycle.MutableLiveData
import sbis.data.model.presentation.PersonSearch
import sbis.helpers.arch.contracts.MvpPresenter
import sbis.helpers.arch.contracts.MvpViewModel

interface SearchVmContract {

    interface ViewModel : MvpViewModel {

        enum class State {
            INITIAL, LOADING, DATA, ERROR
        }

        var state: MutableLiveData<State>

        var errorMessage: MutableLiveData<String?>

        var searchRequest: MutableLiveData<String>

        var searchPersons: MutableLiveData<List<PersonSearch>>
    }

    interface Presenter : MvpPresenter<ViewModel> {
        fun updateSearchRequest(searchRequest: String)

        fun onPersonSelected(person: PersonSearch)

        fun onSecretLongClick()
    }
}