package sbis.data.model.presentation

import android.os.Parcel
import sbis.helpers.arch.parcelable.KParcelable

data class PersonSearch(
    val id: Int,
    val name: String?,
    val secondName: String?,
    val postName: String?,
    val photoUrl: String?
) : KParcelable {

    companion object {
        @JvmField
        val CREATOR = KParcelable.generateCreator(::PersonSearch)
    }

    private constructor(p: Parcel) : this(
        id = p.readInt(),
        name = p.readString(),
        secondName = p.readString(),
        postName = p.readString(),
        photoUrl = p.readString()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(name)
        writeString(secondName)
        writeString(postName)
        writeString(photoUrl)
    }
}