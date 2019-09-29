package com.dmentors.solar_city.presentation.chat

data class Message(
    var type: Type = Type.SELF,
    var message: String = ""
) {
    enum class Type { SELF, FOREIGN }
}