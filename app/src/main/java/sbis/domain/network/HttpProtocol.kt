package sbis.domain.network

enum class HttpProtocol private constructor(val protocolName: String) {
    HTTP("http"),
    HTTPS("https")
}
