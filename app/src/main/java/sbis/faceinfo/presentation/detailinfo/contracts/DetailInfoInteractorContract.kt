package sbis.faceinfo.presentation.detailinfo.contracts

import sbis.data.model.presentation.PersonParams
import sbis.helpers.arch.contracts.MvpInteractor

interface DetailInfoInteractorContract {

    interface Presenter : MvpInteractor.Listener {
        fun obtainedUserFulInfo(user: PersonParams?, error: Throwable?)
    }

    interface Interactor : MvpInteractor<Presenter> {
        fun obtainUserFullInfo(userId: Int)
    }
}