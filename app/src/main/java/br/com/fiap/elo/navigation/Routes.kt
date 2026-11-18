package br.com.fiap.elo.navigation

object Routes {
    const val HOME = "home"
    const val DETALHE = "detalhe/{golpeId}"

    fun detalhe(golpeId: Int): String = "detalhe/$golpeId"
}
