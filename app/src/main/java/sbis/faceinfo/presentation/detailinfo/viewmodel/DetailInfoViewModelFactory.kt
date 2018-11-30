package sbis.faceinfo.presentation.detailinfo.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import sbis.data.model.presentation.PersonSearch

class DetailInfoViewModelFactory(private val user: PersonSearch) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass == DetailInfoViewModel::class.java) {
            with(user) {
                DetailInfoViewModel(
                    id,
                    name ?: "",
                    secondName ?: "",
                    postName ?: "",
                    photoUrl ?: ""
                ) as T
            }
        } else super.create(modelClass)
    }
}