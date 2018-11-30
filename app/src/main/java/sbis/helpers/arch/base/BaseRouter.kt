package sbis.helpers.arch.base

import sbis.helpers.arch.contracts.MvpRouter

abstract class BaseRouter<L : MvpRouter.Listener> : MvpRouter<L> {
    override lateinit var listener: L
}