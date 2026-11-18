package br.com.fiap.elo.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Forum
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Sms
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.fiap.elo.model.Categoria

fun Categoria.icone(): ImageVector {
    return when (this) {
        Categoria.WHATSAPP -> Icons.Default.Forum
        Categoria.SMS -> Icons.Default.Sms
        Categoria.LIGACAO -> Icons.Default.Phone
        Categoria.EMAIL -> Icons.Default.Email
        Categoria.PIX -> Icons.Default.AttachMoney
        Categoria.REDES_SOCIAIS -> Icons.Default.Public
    }
}
