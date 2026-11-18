package br.com.fiap.elo.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Whatshot
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.elo.R
import br.com.fiap.elo.ui.theme.EloNavy
import br.com.fiap.elo.ui.theme.EloTheme
import br.com.fiap.elo.ui.theme.spacingMedium
import br.com.fiap.elo.ui.theme.spacingSmall

@Composable
fun SeloEmAlta(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = MaterialTheme.colorScheme.tertiary,
        contentColor = EloNavy
    ) {
        Row(
            modifier = Modifier.padding(horizontal = spacingMedium, vertical = spacingSmall),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Whatshot,
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(spacingSmall))
            Text(
                text = stringResource(R.string.destaque_selo),
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

@Preview
@Composable
private fun SeloEmAltaPreview() {
    EloTheme {
        SeloEmAlta()
    }
}
