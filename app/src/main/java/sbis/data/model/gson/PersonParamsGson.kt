package sbis.data.model.gson

import com.google.gson.annotations.SerializedName

data class PersonParamsGson(
    @SerializedName("user_often_leaving") val oftenLeaving: Boolean,
    @SerializedName("user_sociability") val sociability: Int,
    @SerializedName("user_procrastination") val procrastination: Int,
    @SerializedName("user_responsibility") val responsibility: Int,
    @SerializedName("user_punctuality") val punctuality: Int
)