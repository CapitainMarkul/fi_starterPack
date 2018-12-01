package sbis.data.model.gson

import com.google.gson.annotations.SerializedName

//todo: Пример оформления модели
// @SerializedName("user_often_leaving") val oftenLeaving: Boolean
// @SerializedName("user_responsibility") val responsibility: Int
data class PersonSearchGson(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("secondName") val secondName: String,
    @SerializedName("photoUrl") val photoUrl: String,
    @SerializedName("postName") val postName: String
)