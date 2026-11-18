package br.com.fiap.elo.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.elo.R
import br.com.fiap.elo.ui.theme.EloTheme
import br.com.fiap.elo.ui.theme.spacingLarge

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EloTopBar(
    titulo: String,
    modifier: Modifier = Modifier,
    subtitulo: String? = null,
    onVoltar: (() -> Unit)? = null
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Column {
                Text(
                    text = titulo,
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                if (subtitulo != null) {
                    Text(
                        text = subtitulo,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        },
        navigationIcon = {
            if (onVoltar != null) {
                IconButton(onClick = onVoltar) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.voltar)
                    )
                }
            } else {
                EloLogo(modifier = Modifier.padding(start = spacingLarge))
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
            navigationIconContentColor = MaterialTheme.colorScheme.onBackground
        )
    )
}

@Preview
@Composable
private fun EloTopBarPreview() {
    EloTheme {
        EloTopBar(
            titulo = "Elo",
            subtitulo = "Proteção contra golpes"
        )
    }
}
