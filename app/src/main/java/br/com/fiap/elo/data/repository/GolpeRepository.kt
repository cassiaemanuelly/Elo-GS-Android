package br.com.fiap.elo.data.repository

import br.com.fiap.elo.R
import br.com.fiap.elo.model.Categoria
import br.com.fiap.elo.model.Golpe
import br.com.fiap.elo.model.NivelRisco

class GolpeRepository {
    private val golpes = listOf(
        Golpe(
            id = 1,
            titulo = "Falso parente",
            descricao = "Alguém se passa por filho ou neto, diz que trocou de número e, " +
                "logo depois, pede um Pix urgente para resolver um problema.",
            sinalDeAlerta = "\"Mãe, troquei de número\" seguido de pedido de dinheiro e de segredo.",
            comoAgir = "Ligue para o número antigo do parente antes de qualquer Pix. " +
                "Se não conseguir falar, não transfira.",
            categorias = listOf(Categoria.WHATSAPP, Categoria.PIX),
            nivelRisco = NivelRisco.ALTO,
            denuncias = 1284,
            imagem = R.drawable.golpe_falso_parente,
            emDestaque = true
        ),
        Golpe(
            id = 2,
            titulo = "Falsa central do banco",
            descricao = "Uma ligação que parece ser do banco avisa sobre uma compra suspeita " +
                "e pede para \"proteger\" o dinheiro transferindo para outra conta.",
            sinalDeAlerta = "O atendente pede senha, código recebido por SMS ou uma transferência.",
            comoAgir = "Desligue e ligue você mesmo para o número que está no verso do cartão.",
            categorias = listOf(Categoria.LIGACAO, Categoria.PIX),
            nivelRisco = NivelRisco.ALTO,
            denuncias = 987,
            imagem = R.drawable.golpe_falsa_central,
            emDestaque = true
        ),
        Golpe(
            id = 3,
            titulo = "Falso INSS",
            descricao = "Mensagem ou ligação diz que o benefício será bloqueado se a prova " +
                "de vida não for feita por um link ou com o envio de dados.",
            sinalDeAlerta = "Ameaça de cortar a aposentadoria e link fora do site gov.br.",
            comoAgir = "Confira no app Meu INSS ou pelo telefone 135. O INSS não envia links por mensagem.",
            categorias = listOf(Categoria.SMS, Categoria.LIGACAO),
            nivelRisco = NivelRisco.ALTO,
            denuncias = 812,
            imagem = R.drawable.golpe_falso_inss,
            emDestaque = true
        ),
        Golpe(
            id = 4,
            titulo = "Loja falsa",
            descricao = "Anúncio nas redes sociais oferece produto com desconto enorme e " +
                "aceita pagamento apenas por Pix.",
            sinalDeAlerta = "Preço muito abaixo do normal, prazo curto e só pagamento por Pix.",
            comoAgir = "Pesquise a loja no Reclame Aqui e prefira sites oficiais e cartão de crédito.",
            categorias = listOf(Categoria.REDES_SOCIAIS, Categoria.PIX),
            nivelRisco = NivelRisco.MEDIO,
            denuncias = 645,
            imagem = R.drawable.golpe_loja_falsa,
            emDestaque = true
        ),
        Golpe(
            id = 5,
            titulo = "Clonagem do WhatsApp",
            descricao = "O golpista pede o código de 6 dígitos que chegou por SMS, dizendo " +
                "ser de uma pesquisa ou de um cadastro, e assume a conta.",
            sinalDeAlerta = "Qualquer pessoa pedindo o código que chegou por SMS.",
            comoAgir = "Nunca compartilhe o código. Ative a confirmação em duas etapas no WhatsApp.",
            categorias = listOf(Categoria.WHATSAPP, Categoria.SMS),
            nivelRisco = NivelRisco.ALTO,
            denuncias = 533,
            imagem = R.drawable.golpe_clonagem_whatsapp
        ),
        Golpe(
            id = 6,
            titulo = "Mão fantasma",
            descricao = "Falso técnico do banco pede para instalar um aplicativo de " +
                "\"segurança\" que, na verdade, dá acesso remoto ao celular.",
            sinalDeAlerta = "Pedido para instalar aplicativo ou compartilhar a tela durante a ligação.",
            comoAgir = "Não instale nada a pedido de terceiros. Desligue e procure a agência.",
            categorias = listOf(Categoria.LIGACAO),
            nivelRisco = NivelRisco.ALTO,
            denuncias = 418,
            imagem = R.drawable.golpe_mao_fantasma
        ),
        Golpe(
            id = 7,
            titulo = "Entrega pendente",
            descricao = "SMS informa que uma encomenda está retida e cobra uma pequena taxa " +
                "por um link para liberar a entrega.",
            sinalDeAlerta = "Taxa para liberar encomenda que você não lembra de ter comprado.",
            comoAgir = "Não clique no link. Consulte o rastreio apenas no site oficial dos Correios.",
            categorias = listOf(Categoria.SMS),
            nivelRisco = NivelRisco.MEDIO,
            denuncias = 376,
            imagem = R.drawable.golpe_entrega_pendente
        ),
        Golpe(
            id = 8,
            titulo = "Empréstimo falso",
            descricao = "Oferta de empréstimo com juros baixíssimos para aposentados, mas é " +
                "preciso pagar uma taxa antecipada para liberar o dinheiro.",
            sinalDeAlerta = "Cobrança de qualquer valor antes de receber o empréstimo.",
            comoAgir = "Empréstimo de verdade não cobra taxa antecipada. Negocie só com o seu banco.",
            categorias = listOf(Categoria.LIGACAO, Categoria.WHATSAPP),
            nivelRisco = NivelRisco.MEDIO,
            denuncias = 291,
            imagem = R.drawable.golpe_falso_emprestimo
        ),
        Golpe(
            id = 9,
            titulo = "Boleto falso",
            descricao = "E-mail com a marca de uma empresa conhecida envia um boleto com " +
                "dados bancários alterados.",
            sinalDeAlerta = "Beneficiário com nome diferente da empresa na hora de pagar.",
            comoAgir = "Confira o nome do beneficiário antes de pagar e emita a 2ª via no site oficial.",
            categorias = listOf(Categoria.EMAIL),
            nivelRisco = NivelRisco.MEDIO,
            denuncias = 204,
            imagem = R.drawable.golpe_boleto_falso
        ),
        Golpe(
            id = 10,
            titulo = "Falso prêmio",
            descricao = "Mensagem avisa que você ganhou um prêmio, mas pede dados pessoais " +
                "ou uma taxa para fazer a entrega.",
            sinalDeAlerta = "Prêmio de um sorteio do qual você nunca participou.",
            comoAgir = "Ignore e apague a mensagem. Prêmio de verdade não cobra para ser entregue.",
            categorias = listOf(Categoria.WHATSAPP, Categoria.REDES_SOCIAIS, Categoria.EMAIL),
            nivelRisco = NivelRisco.BAIXO,
            denuncias = 157,
            imagem = R.drawable.golpe_falso_premio
        )
    )

    fun getGolpes(): List<Golpe> = golpes

    fun getDestaques(): List<Golpe> = golpes.filter { golpe -> golpe.emDestaque }

    fun filtrarPorCategoria(categoria: Categoria?): List<Golpe> =
        if (categoria == null) golpes
        else golpes.filter { golpe -> categoria in golpe.categorias }

    fun buscarPorId(id: Int): Golpe? {
        for (golpe in golpes) {
            if (golpe.id == id) {
                return golpe
            }
        }
        return null
    }

    fun totalDenuncias(): Int {
        var total = 0
        for (golpe in golpes) {
            total += golpe.denuncias
        }
        return total
    }
}
