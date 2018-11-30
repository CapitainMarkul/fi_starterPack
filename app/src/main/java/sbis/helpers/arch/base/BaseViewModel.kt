package sbis.helpers.arch.base

import android.arch.lifecycle.ViewModel
import sbis.helpers.arch.contracts.MvpViewModel
import java.util.*

abstract class BaseViewModel(override val id: UUID = UUID.randomUUID()) : ViewModel(), MvpViewModel