package sbis.helpers.arch.contracts

import android.app.Activity
import android.support.v4.app.FragmentManager

interface AndroidComponent {
    val activity: Activity
    val fragmentManager: FragmentManager
}