package sbis.faceinfo.presentation.search.contracts

import sbis.helpers.arch.contracts.MvpRouter

interface SearchRouterContract {

    interface Router : MvpRouter<Presenter> {

        // todo: fun showDetailInfo(androidComponent: AndroidComponent, user: PersonSearch)

        // todo: fun showSettingScreen(androidComponent: AndroidComponent)
    }

    interface Presenter : MvpRouter.Listener {

    }

}