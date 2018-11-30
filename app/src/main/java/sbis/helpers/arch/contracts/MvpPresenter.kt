package sbis.helpers.arch.contracts

interface MvpPresenter<VM : MvpViewModel> {
    fun attachView(viewModel: VM, component: AndroidComponent)

    fun detachView()

    fun isAttachedView() : Boolean

    var vm : VM

    fun destroy()
}