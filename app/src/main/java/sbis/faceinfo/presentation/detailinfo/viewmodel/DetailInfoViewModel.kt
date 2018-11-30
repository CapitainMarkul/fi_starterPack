package sbis.faceinfo.presentation.detailinfo.viewmodel

import android.arch.lifecycle.MutableLiveData
import sbis.data.model.presentation.PersonParams
import sbis.faceinfo.presentation.detailinfo.contracts.DetailInfoVmContract
import sbis.faceinfo.presentation.detailinfo.contracts.DetailInfoVmContract.ViewModel.State
import sbis.helpers.arch.base.BaseViewModel

class DetailInfoViewModel(
    override val userId: Int,
    override val userName: String,
    override val userSecondName: String,
    override val userPostName: String,
    override val userPhotoUrl: String
) : BaseViewModel(), DetailInfoVmContract.ViewModel {
    override var state = MutableLiveData<State>().apply { value = State.INITIAL }
    override var errorMessage = MutableLiveData<String?>().apply { value = null }
    override var userParams = MutableLiveData<PersonParams?>().apply { value = null }
}