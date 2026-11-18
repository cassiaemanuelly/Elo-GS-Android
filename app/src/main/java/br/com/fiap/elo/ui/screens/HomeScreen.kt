package br.com.fiap.elo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.elo.R
import br.com.fiap.elo.data.repository.GolpeRepository
import br.com.fiap.elo.model.Categoria
import br.com.fiap.elo.model.Golpe
import br.com.fiap.elo.ui.components.CategoriaSelector
import br.com.fiap.elo.ui.components.DestaquesSection
import br.com.fiap.elo.ui.components.EloTopBar
import br.com.fiap.elo.ui.components.GolpeCard
import br.com.fiap.elo.ui.components.ResumoCard
import br.com.fiap.elo.ui.components.SecaoTitulo
import br.com.fiap.elo.ui.theme.EloTheme
import br.com.fiap.elo.ui.theme.spacingLarge
import br.com.fiap.elo.ui.theme.spacingMedium
import br.com.fiap.elo.ui.theme.spacingXLarge

@Composable
fun HomeScreen(
    onGolpeClick: (Golpe) -> Unit,
    repository: GolpeRepository = GolpeRepository()
) {
    var categoriaSelecionada by rememberSaveable { mutableStateOf<Categoria?>(null) }

    val destaques = repository.getDestaques()
    val golpesFiltrados = repository.filtrarPorCategoria(categoriaSelecionada)

    Scaffold(
        topBar = {
            EloTopBar(
                titulo = stringResource(R.string.home_titulo),
                subtitulo = stringResource(R.string.home_subtitulo)
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(top = spacingMedium, bottom = spacingXLarge),
            verticalArrangement = Arrangement.spacedBy(spacingMedium)
        ) {
            item {
                ResumoCard(
                    totalGolpes = repository.getGolpes().size,
                    totalDenuncias = repository.totalDenuncias(),
                    modifier = Modifier.padding(horizontal = spacingLarge)
                )
            }

            item {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.height(spacingLarge))
                    SecaoTitulo(
                        titulo = stringResource(R.string.secao_destaques),
                        subtitulo = stringResource(R.string.secao_destaques_apoio),
                        modifier = Modifier.padding(horizontal = spacingLarge)
                    )
                    Spacer(modifier = Modifier.height(spacingMedium))
                    DestaquesSection(
                        destaques = destaques,
                        onGolpeClick = onGolpeClick
                    )
                }
            }

            item {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.height(spacingLarge))
                    SecaoTitulo(
                        titulo = stringResource(R.string.secao_categorias),
                        modifier = Modifier.padding(horizontal = spacingLarge)
                    )
                    Spacer(modifier = Modifier.height(spacingMedium))
                    CategoriaSelector(
                        categorias = Categoria.entries,
                        categoriaSelecionada = categoriaSelecionada,
                        onCategoriaSelecionada = { categoria -> categoriaSelecionada = categoria }
                    )
                }
            }

            item {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.height(spacingLarge))
                    SecaoTitulo(
                        titulo = stringResource(R.string.secao_lista, golpesFiltrados.size),
                        modifier = Modifier.padding(horizontal = spacingLarge)
                    )
                }
            }

            if (golpesFiltrados.isEmpty()) {
                item {
                    Text(
                        text = stringResource(R.string.lista_vazia),
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(spacingXLarge)
                    )
                }
            }

            items(items = golpesFiltrados, key = { golpe -> golpe.id }) { golpe ->
                GolpeCard(
                    golpe = golpe,
                    onClick = { onGolpeClick(golpe) },
                    modifier = Modifier.padding(horizontal = spacingLarge)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    EloTheme {
        HomeScreen(onGolpeClick = {})
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenDarkPreview() {
    EloTheme(darkTheme = true) {
        HomeScreen(onGolpeClick = {})
    }
}
