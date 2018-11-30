package sbis.faceinfo.presentation.detailinfo.presenter

import sbis.App
import sbis.faceinfo.presentation.detailinfo.contracts.DetailInfoInteractorContract
import sbis.faceinfo.presentation.detailinfo.contracts.DetailInfoRouterContract
import sbis.faceinfo.presentation.detailinfo.contracts.DetailInfoVmContract
import sbis.helpers.arch.base.BasePresenter
import sbis.helpers.arch.contracts.AndroidComponent
import sbis.helpers.network.cancelAllCalls

class DetailInfoPresenter(
    val interactor: DetailInfoInteractorContract.Interactor,
    val router: DetailInfoRouterContract.Router
) : BasePresenter<DetailInfoVmContract.ViewModel>(),
    DetailInfoVmContract.Presenter,
    DetailInfoInteractorContract.Presenter,
    DetailInfoRouterContract.Presenter {

    override fun attachView(viewModel: DetailInfoVmContract.ViewModel, component: AndroidComponent) {
        super.attachView(viewModel, component)
        interactor.listener = this

        //TODO: Check start 'State == INITIAL'
        //TODO: interactor.obtainFullInfo(...)
    }

    override fun detachView() {
        super.detachView()

        App.get().getNetworkClient().cancelAllCalls()
    }

    //TODO: obtainedUserFulInfo(user: PersonFullInfo?, error: Throwable?)
//TODO: Handle error and set data
}