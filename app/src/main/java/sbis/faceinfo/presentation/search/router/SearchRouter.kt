package sbis.faceinfo.presentation.search.router

import sbis.data.model.presentation.PersonSearch
import sbis.faceinfo.presentation.detailinfo.view.activity.DetailInfoActivity
import sbis.faceinfo.presentation.search.contracts.SearchRouterContract
import sbis.faceinfo.presentation.setting.SettingActivity
import sbis.helpers.arch.base.BaseRouter
import sbis.helpers.arch.contracts.AndroidComponent

class SearchRouter() : BaseRouter<SearchRouterContract.Presenter>(), SearchRouterContract.Router {

    override fun showDetailInfo(androidComponent: AndroidComponent, user: PersonSearch) {
        val activity = androidComponent.activity
        val intent = DetailInfoActivity.createIntent(activity, user)
        activity.startActivity(intent)
    }

    override fun showSettingScreen(androidComponent: AndroidComponent) {
        val activity = androidComponent.activity
        val intent = SettingActivity.createIntent(activity)
        activity.startActivity(intent)
    }
}