package sbis.helpers.arch.base

import sbis.helpers.arch.contracts.AndroidComponent
import sbis.helpers.arch.contracts.MvpPresenter
import sbis.helpers.arch.contracts.MvpViewModel

abstract class BasePresenter<VM : MvpViewModel> : MvpPresenter<VM> {

    override lateinit var vm: VM
    protected var androidComponent: AndroidComponent? = null

    override fun attachView(viewModel: VM, component: AndroidComponent) {
        vm = viewModel
        androidComponent = component
    }

    override fun detachView() {
        androidComponent = null
    }

    override fun isAttachedView() = androidComponent != null

    override fun destroy() {
    }
}