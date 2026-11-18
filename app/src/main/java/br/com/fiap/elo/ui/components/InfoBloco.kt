package br.com.fiap.elo.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.elo.ui.theme.EloTheme

@Composable
fun InfoBloco(
    icone: ImageVector,
    titulo: String,
    texto: String,
    modifier: Modifier = Modifier,
    enfatizado: Boolean = false
) {
    val corFundo =
        if (enfatizado) MaterialTheme.colorScheme.secondaryContainer
        else MaterialTheme.colorScheme.surface
    val corConteudo =
        if (enfatizado) MaterialTheme.colorScheme.onSecondaryContainer
        else MaterialTheme.colorScheme.onSurface
    val corIcone =
        if (enfatizado) MaterialTheme.colorScheme.onSecondaryContainer
        else MaterialTheme.colorScheme.secondary

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = corFundo,
            contentColor = corConteudo
        )
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Icon(
                imageVector = icone,
                contentDescription = null,
                tint = corIcone,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = titulo,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = texto,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InfoBlocoPreview() {
    EloTheme {
        InfoBloco(
            icone = Icons.Default.Warning,
            titulo = "Sinal de alerta",
            texto = "Pedido de Pix com urgência e de segredo.",
            modifier = Modifier.padding(16.dp),
            enfatizado = true
        )
    }
}
