package br.com.fiap.elo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.elo.R
import br.com.fiap.elo.ui.theme.EloNavy
import br.com.fiap.elo.ui.theme.EloTheme
import br.com.fiap.elo.ui.theme.logoTopBar
import br.com.fiap.elo.ui.theme.spacingSmall

@Composable
fun EloLogo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo_elo),
        contentDescription = stringResource(R.string.logo_descricao),
        contentScale = ContentScale.Fit,
        modifier = modifier
            .size(logoTopBar)
            .background(EloNavy, shape = CircleShape)
            .padding(spacingSmall)
    )
}

@Preview
@Composable
private fun EloLogoPreview() {
    EloTheme {
        EloLogo()
    }
}
