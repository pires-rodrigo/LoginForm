package com.example.loginform.modelo

import java.time.LocalDate

enum class TipoViagem {
    Lazer,
    Negocio
}
data class Viagem(
    val id       : Int = 0,
    val destino  : String = "",
    val tipo     : TipoViagem = TipoViagem.Lazer,
    val orcamento: Float = 0f,
    val dtInicio : LocalDate,
    val dtFim    : LocalDate
) {
}