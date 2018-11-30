package sbis.helpers.arch.parcelable

import android.os.Parcel
import android.os.Parcelable

/**
 * Generic Parcelable interface for easily creating parcelables.
 */
interface KParcelable : Parcelable {

    override fun describeContents(): Int = 0

    companion object {

        inline fun <reified T> generateCreator(crossinline create: (Parcel) -> T) =
            object : Parcelable.Creator<T> {

                override fun createFromParcel(source: Parcel) = create(source)

                override fun newArray(size: Int) = arrayOfNulls<T>(size)
            }

        inline fun <reified T> generateClassLoaderCreator(crossinline create: (Parcel, ClassLoader) -> T) =
            object : Parcelable.ClassLoaderCreator<T> {

                override fun createFromParcel(source: Parcel, loader: ClassLoader) = create(source, loader)

                override fun createFromParcel(source: Parcel) = createFromParcel(source, T::class.java.classLoader)

                override fun newArray(size: Int) = arrayOfNulls<T>(size)
            }
    }
}