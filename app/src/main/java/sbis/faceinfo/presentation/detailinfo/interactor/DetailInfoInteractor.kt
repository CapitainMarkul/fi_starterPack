package sbis.faceinfo.presentation.detailinfo.interactor

import sbis.domain.network.service.network.NetworkService
import sbis.faceinfo.presentation.detailinfo.contracts.DetailInfoInteractorContract
import sbis.helpers.arch.base.BaseInteractor

class DetailInfoInteractor(private val networkService: NetworkService) :
    BaseInteractor<DetailInfoInteractorContract.Presenter>(),
    DetailInfoInteractorContract.Interactor {

    //TODO: obtainUserFullInfo(userId: Int)
    //      networkService.getPersonFullInfo(...)
}