package br.com.fiap.elo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.elo.R
import br.com.fiap.elo.model.Golpe
import br.com.fiap.elo.data.repository.GolpeRepository
import br.com.fiap.elo.ui.components.CategoriaTag
import br.com.fiap.elo.ui.components.EloTopBar
import br.com.fiap.elo.ui.components.InfoBloco
import br.com.fiap.elo.ui.components.NivelRiscoBadge
import br.com.fiap.elo.ui.components.SeloEmAlta
import br.com.fiap.elo.ui.theme.EloTheme
import br.com.fiap.elo.ui.theme.spacingLarge
import br.com.fiap.elo.ui.theme.spacingMedium
import java.util.Locale

@Composable
fun GolpeDetailScreen(
    golpe: Golpe,
    onVoltar: () -> Unit
) {
    Scaffold(
        topBar = {
            EloTopBar(
                titulo = stringResource(R.string.detalhe_titulo),
                onVoltar = onVoltar
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(horizontal = spacingLarge, vertical = spacingMedium),
            verticalArrangement = Arrangement.spacedBy(spacingLarge)
        ) {
            item {
                Image(
                    painter = painterResource(golpe.imagem),
                    contentDescription = stringResource(R.string.imagem_descricao, golpe.titulo),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
            }

            item {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = golpe.titulo,
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        NivelRiscoBadge(nivelRisco = golpe.nivelRisco)
                        if (golpe.emDestaque) {
                            Spacer(modifier = Modifier.width(8.dp))
                            SeloEmAlta()
                        }
                    }
                }
            }

            item {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = stringResource(R.string.detalhe_canais),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(golpe.categorias) { categoria ->
                            CategoriaTag(categoria = categoria)
                        }
                    }
                }
            }

            item {
                InfoBloco(
                    icone = Icons.Default.Info,
                    titulo = stringResource(R.string.detalhe_como_chega),
                    texto = golpe.descricao,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            item {
                InfoBloco(
                    icone = Icons.Default.Warning,
                    titulo = stringResource(R.string.detalhe_sinal),
                    texto = golpe.sinalDeAlerta,
                    modifier = Modifier.fillMaxWidth(),
                    enfatizado = true
                )
            }

            item {
                InfoBloco(
                    icone = Icons.Default.VerifiedUser,
                    titulo = stringResource(R.string.detalhe_como_agir),
                    texto = golpe.comoAgir,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            item {
                InfoBloco(
                    icone = Icons.Default.Groups,
                    titulo = stringResource(R.string.detalhe_comunidade),
                    texto = stringResource(
                        R.string.detalhe_comunidade_texto,
                        formatarNumero(golpe.denuncias)
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

private fun formatarNumero(valor: Int): String {
    return String.format(Locale.US, "%,d", valor).replace(',', '.')
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GolpeDetailScreenPreview() {
    EloTheme {
        GolpeDetailScreen(
            golpe = GolpeRepository().getGolpes()[0],
            onVoltar = {}
        )
    }
}
