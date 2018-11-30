@file:JvmName("ParcelExtensions")

package sbis.helpers.arch.parcelable

import android.os.Parcel
import java.math.BigDecimal
import java.math.BigInteger
import java.util.*

fun Parcel.readDate() =
    readNullable { Date(readLong()) }

fun Parcel.writeDate(value: Date?) =
    writeNullable(value) { writeLong(it.time) }

fun Parcel.readBigInteger() =
    readNullable { BigInteger(createByteArray()) }

fun Parcel.writeBigInteger(value: BigInteger?) =
    writeNullable(value) { writeByteArray(it.toByteArray()) }

fun Parcel.readBigDecimal() =
    readNullable { BigDecimal(BigInteger(createByteArray()), readInt()) }

fun Parcel.writeBigDecimal(value: BigDecimal?) = writeNullable(value) {
    writeByteArray(it.unscaledValue().toByteArray())
    writeInt(it.scale())
}

fun <K, V> Parcel.readMap(map: MutableMap<K, V>): MutableMap<K, V> {

    val tempMap = LinkedHashMap<Any?, Any?>()
    readMap(tempMap, map.javaClass.classLoader)

    tempMap.forEach {
        map[it.key as K] = it.value as V
    }

    return map
}

inline fun <T> Parcel.readNullable(reader: () -> T) = if (readInt() != 0) reader() else null

inline fun <T> Parcel.writeNullable(value: T?, writer: (T) -> Unit) {
    if (value != null) {
        writeInt(1)
        writer(value)
    } else {
        writeInt(0)
    }
}

inline fun <reified T : Enum<T>> Parcel.readEnum() = readInt().let { if (it >= 0) enumValues<T>()[it] else null }

inline fun <reified T : Enum<T>> Parcel.readEnumList(): List<T> {
    val enumValues = enumValues<T>()
    return createIntArray().map { enumValues[it] }
}

fun <T : Enum<T>> Parcel.writeEnum(value: T?) = writeInt(value?.ordinal ?: -1)

fun <T : Enum<T>> Parcel.writeEnumList(value: List<T>) = writeIntArray(IntArray(value.size) { value[it].ordinal })