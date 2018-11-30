package sbis.faceinfo.presentation.detailinfo.router

import sbis.faceinfo.presentation.detailinfo.contracts.DetailInfoRouterContract
import sbis.helpers.arch.base.BaseRouter
import sbis.helpers.arch.contracts.AndroidComponent

class DetailInfoRouter : BaseRouter<DetailInfoRouterContract.Presenter>(), DetailInfoRouterContract.Router {

    override fun performFinish(androidComponent: AndroidComponent) {
        androidComponent.activity.finish()
    }
}