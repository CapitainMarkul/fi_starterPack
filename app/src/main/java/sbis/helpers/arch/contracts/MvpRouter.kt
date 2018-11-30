package sbis.helpers.arch.contracts

interface MvpRouter<L : MvpRouter.Listener> {
    interface Listener

    var listener: L
}