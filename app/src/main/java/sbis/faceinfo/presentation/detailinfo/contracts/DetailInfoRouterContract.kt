package sbis.faceinfo.presentation.detailinfo.contracts

import sbis.helpers.arch.contracts.AndroidComponent
import sbis.helpers.arch.contracts.MvpRouter

interface DetailInfoRouterContract {

    interface Router : MvpRouter<Presenter> {
        fun performFinish(androidComponent: AndroidComponent)
    }

    interface Presenter : MvpRouter.Listener {

    }

}