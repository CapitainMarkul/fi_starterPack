package sbis.faceinfo.presentation.detailinfo.contracts

import sbis.helpers.arch.contracts.MvpInteractor

interface DetailInfoInteractorContract {

    interface Presenter : MvpInteractor.Listener {
        //TODO: obtainedUserFulInfo(user: PersonFullInfo?, error: Throwable?)
    }

    interface Interactor : MvpInteractor<Presenter> {
        //TODO: obtainUserFullInfo(userId: String)
    }
}