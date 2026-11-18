package br.com.fiap.elo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.elo.ui.theme.iconSmall
import br.com.fiap.elo.ui.theme.spacingLarge
import br.com.fiap.elo.ui.theme.spacingMedium
import br.com.fiap.elo.R
import br.com.fiap.elo.model.Categoria
import br.com.fiap.elo.ui.theme.EloTheme

@Composable
fun CategoriaSelector(
    categorias: List<Categoria>,
    categoriaSelecionada: Categoria?,
    onCategoriaSelecionada: (Categoria?) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = spacingLarge),
        horizontalArrangement = Arrangement.spacedBy(spacingMedium)
    ) {
        item {
            CategoriaChip(
                texto = stringResource(R.string.categoria_todas),
                icone = Icons.Default.Apps,
                selecionada = categoriaSelecionada == null,
                onClick = { onCategoriaSelecionada(null) }
            )
        }
        items(categorias) { categoria ->
            CategoriaChip(
                texto = categoria.label,
                icone = categoria.icone(),
                selecionada = categoriaSelecionada == categoria,
                onClick = { onCategoriaSelecionada(categoria) }
            )
        }
    }
}

@Composable
private fun CategoriaChip(
    texto: String,
    icone: ImageVector,
    selecionada: Boolean,
    onClick: () -> Unit
) {
    FilterChip(
        selected = selecionada,
        onClick = onClick,
        label = {
            Text(
                text = texto,
                style = MaterialTheme.typography.labelLarge
            )
        },
        leadingIcon = {
            Icon(
                imageVector = if (selecionada) Icons.Default.Check else icone,
                contentDescription = null,
                modifier = Modifier.size(iconSmall)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun CategoriaSelectorPreview() {
    EloTheme {
        var selecionada by remember { mutableStateOf<Categoria?>(null) }
        CategoriaSelector(
            categorias = Categoria.entries,
            categoriaSelecionada = selecionada,
            onCategoriaSelecionada = { selecionada = it },
            modifier = Modifier.padding(vertical = 16.dp)
        )
    }
}
