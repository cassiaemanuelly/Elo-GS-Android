package br.com.fiap.elo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.elo.R
import br.com.fiap.elo.model.Golpe
import br.com.fiap.elo.data.repository.GolpeRepository
import br.com.fiap.elo.ui.theme.EloTheme
import br.com.fiap.elo.ui.theme.spacingMedium
import java.util.Locale

@Composable
fun DestaqueCard(
    golpe: Golpe,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier.width(240.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Box {
            Image(
                painter = painterResource(golpe.imagem),
                contentDescription = stringResource(R.string.imagem_descricao, golpe.titulo),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
            )

            SeloEmAlta(modifier = Modifier.padding(spacingMedium))
        }

        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = golpe.titulo,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            NivelRiscoBadge(nivelRisco = golpe.nivelRisco)
            Spacer(modifier = Modifier.height(8.dp))
            InfoLinha(
                icone = Icons.Default.Groups,
                texto = stringResource(R.string.denuncias, formatarNumero(golpe.denuncias))
            )
        }
    }
}

private fun formatarNumero(valor: Int): String {
    return String.format(Locale.US, "%,d", valor).replace(',', '.')
}

@Preview(showBackground = true)
@Composable
private fun DestaqueCardPreview() {
    EloTheme {
        DestaqueCard(
            golpe = GolpeRepository().getDestaques()[0],
            onClick = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}
