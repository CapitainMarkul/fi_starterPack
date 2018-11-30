package sbis.data.model.presentation

import android.os.Parcel
import sbis.helpers.arch.parcelable.KParcelable
import sbis.helpers.arch.parcelable.readEnum
import sbis.helpers.arch.parcelable.writeEnum

data class ItemParam(
    val param: Param,
    val value: Int
) : KParcelable {

    companion object {
        @JvmField
        val CREATOR = KParcelable.generateCreator(::ItemParam)
    }

    private constructor(p: Parcel) : this(
        param = p.readEnum<Param>()!!,
        value = p.readInt()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeEnum(param)
        writeInt(value)
    }
}