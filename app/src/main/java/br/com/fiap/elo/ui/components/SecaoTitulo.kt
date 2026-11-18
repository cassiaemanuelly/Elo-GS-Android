package br.com.fiap.elo.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.elo.ui.theme.EloTheme

@Composable
fun SecaoTitulo(
    titulo: String,
    modifier: Modifier = Modifier,
    subtitulo: String? = null
) {
    Column(modifier = modifier) {
        Text(
            text = titulo,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )
        if (subtitulo != null) {
            Text(
                text = subtitulo,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SecaoTituloPreview() {
    EloTheme {
        SecaoTitulo(
            titulo = "Golpes em alta",
            subtitulo = "Os mais denunciados nesta semana"
        )
    }
}
