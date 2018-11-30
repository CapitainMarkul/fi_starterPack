package sbis.helpers.arch.base

import sbis.App
import sbis.helpers.arch.contracts.MvpInteractor

abstract class BaseInteractor<L : MvpInteractor.Listener> : MvpInteractor<L> {

    override var listener: L? = null

    fun runUi(action: () -> Unit) {
        App.get().handlerUi.post { action() }
    }
}