package sbis.data.model.presentation

enum class Param(
    val title: String,
    val isNegative: Boolean
) {
    RESPONSIBILITY("Ответственность", false),
    PROCRASTINATION("Прокрастинация", true),
    SOCIABILITY("Коммуникабельность", false),
    PUNCTUALITY("Пунктуальность", false)
}