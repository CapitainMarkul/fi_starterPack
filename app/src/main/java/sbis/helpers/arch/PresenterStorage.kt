package sbis.helpers.arch

import sbis.helpers.arch.contracts.MvpPresenter
import java.util.*

class PresenterStorage private constructor() {

    private val cache: MutableMap<UUID, in MvpPresenter<*>> = HashMap()

    fun save(uid: UUID, presenter: MvpPresenter<*>) {
        cache[uid] = presenter
    }

    fun <T : MvpPresenter<*>> evict(uid: UUID): T {
        return cache.remove(uid) as T
    }

    companion object {
        private var sInstance: PresenterStorage? = null

        val instance: PresenterStorage
            @Synchronized get() {
                if (sInstance == null) {
                    sInstance = PresenterStorage()
                }
                return sInstance as PresenterStorage
            }
    }
}
