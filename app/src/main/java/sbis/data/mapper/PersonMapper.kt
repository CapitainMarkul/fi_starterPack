package sbis.data.mapper

import sbis.data.model.gson.PersonParamsGson
import sbis.data.model.presentation.ItemParam
import sbis.data.model.presentation.Param
import sbis.data.model.presentation.PersonParams
import sbis.data.model.gson.PersonSearchGson
import sbis.data.model.presentation.PersonSearch

fun PersonParamsGson.transformToPresentation() = PersonParams(
    oftenLeaving = oftenLeaving,
    params = arrayListOf(
        ItemParam(Param.PROCRASTINATION, procrastination),
        ItemParam(Param.PUNCTUALITY, punctuality),
        ItemParam(Param.RESPONSIBILITY, responsibility),
        ItemParam(Param.SOCIABILITY, sociability)
    )
)
fun PersonSearchGson.transformToPresentation()  =
        PersonSearch(
            id = id,
            name = name,
            photoUrl = photoUrl,
            postName = postName,
            secondName = secondName
        )

fun List<PersonSearchGson>.transformToPresentation() =
       map { it.transformToPresentation() }
