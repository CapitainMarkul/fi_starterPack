package sbis.data.mapper

import sbis.data.model.gson.PersonParamsGson
import sbis.data.model.presentation.ItemParam
import sbis.data.model.presentation.Param
import sbis.data.model.presentation.PersonParams

//TODO: PersonSearchGson to PersonSearch
//TODO: List<PersonSearchGson> to List<PersonSearch>


//fun PersonParamsGson.transformToPresentation() = PersonParams(
//    oftenLeaving = oftenLeaving,
//    params = map { it. }
//)
fun PersonParamsGson.transformToPresentation() = PersonParams(
    oftenLeaving = oftenLeaving,
    params = arrayListOf(
        ItemParam(Param.PROCRASTINATION, procrastination),
        ItemParam(Param.PUNCTUALITY, punctuality),
        ItemParam(Param.RESPONSIBILITY, responsibility),
        ItemParam(Param.SOCIABILITY, sociability)
    )
)

// ============ ПРИМЕР ============
//fun ItemParamGson.transformToPresentation() =
//    ItemParam(
//        title = title,
//        value = value
//    )
//
//fun List<ItemParamGson>.transformToPresentationItemParamList() =
//    map { it.transformToPresentation() }