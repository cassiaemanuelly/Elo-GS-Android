package br.com.fiap.elo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.elo.model.Golpe
import br.com.fiap.elo.data.repository.GolpeRepository
import br.com.fiap.elo.ui.theme.EloTheme

@Composable
fun DestaquesSection(
    destaques: List<Golpe>,
    onGolpeClick: (Golpe) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items = destaques, key = { golpe -> golpe.id }) { golpe ->
            DestaqueCard(
                golpe = golpe,
                onClick = { onGolpeClick(golpe) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DestaquesSectionPreview() {
    EloTheme {
        DestaquesSection(
            destaques = GolpeRepository().getDestaques(),
            onGolpeClick = {},
            modifier = Modifier.padding(vertical = 16.dp)
        )
    }
}
