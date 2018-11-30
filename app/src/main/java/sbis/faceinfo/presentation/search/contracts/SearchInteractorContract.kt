package sbis.faceinfo.presentation.search.contracts

import sbis.data.model.presentation.PersonSearch
import sbis.helpers.arch.contracts.MvpInteractor

interface SearchInteractorContract {

    interface Presenter : MvpInteractor.Listener {
        fun obtainedPersons(persons: List<PersonSearch>, error: Throwable?)
    }

    interface Interactor : MvpInteractor<Presenter> {
        fun obtainPersons(searchRequest: String)
    }
}