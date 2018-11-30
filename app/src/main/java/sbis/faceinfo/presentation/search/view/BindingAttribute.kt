package sbis.faceinfo.presentation.search.view

import android.arch.lifecycle.MutableLiveData
import android.databinding.BindingAdapter
import android.view.View
import sbis.data.model.presentation.PersonSearch
import sbis.faceinfo.presentation.search.contracts.SearchVmContract.ViewModel.State

@BindingAdapter(value = ["list_person", "state_vm"], requireAll = false)
fun View.stubVisibility(listPerson: MutableLiveData<List<PersonSearch>>, state: MutableLiveData<State>) {
    visibility =
            if (listPerson.value!!.isNotEmpty() || state.value!! == State.LOADING) View.INVISIBLE
            else View.VISIBLE
}