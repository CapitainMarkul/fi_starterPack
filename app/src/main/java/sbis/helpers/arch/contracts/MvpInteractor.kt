package sbis.helpers.arch.contracts

interface MvpInteractor<L : MvpInteractor.Listener> {

    var listener: L?

    interface Listener
}