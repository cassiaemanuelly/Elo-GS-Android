package br.com.fiap.elo.model

import androidx.annotation.DrawableRes

data class Golpe(
    val id: Int,
    val titulo: String,
    val descricao: String,
    val sinalDeAlerta: String,
    val comoAgir: String,
    val categorias: List<Categoria>,
    val nivelRisco: NivelRisco,
    val denuncias: Int,
    @DrawableRes val imagem: Int,
    val emDestaque: Boolean = false
)
