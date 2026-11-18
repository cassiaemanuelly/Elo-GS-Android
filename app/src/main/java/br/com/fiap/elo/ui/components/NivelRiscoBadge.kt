package br.com.fiap.elo.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
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
import br.com.fiap.elo.model.NivelRisco
import br.com.fiap.elo.ui.theme.EloTheme
import br.com.fiap.elo.ui.theme.RiscoAltoClaro
import br.com.fiap.elo.ui.theme.RiscoAltoEscuro
import br.com.fiap.elo.ui.theme.RiscoAltoTextoClaro
import br.com.fiap.elo.ui.theme.RiscoAltoTextoEscuro
import br.com.fiap.elo.ui.theme.RiscoBaixoClaro
import br.com.fiap.elo.ui.theme.RiscoBaixoEscuro
import br.com.fiap.elo.ui.theme.RiscoBaixoTextoClaro
import br.com.fiap.elo.ui.theme.RiscoBaixoTextoEscuro
import br.com.fiap.elo.ui.theme.RiscoMedioClaro
import br.com.fiap.elo.ui.theme.RiscoMedioEscuro
import br.com.fiap.elo.ui.theme.RiscoMedioTextoClaro
import br.com.fiap.elo.ui.theme.RiscoMedioTextoEscuro
import br.com.fiap.elo.ui.theme.spacingMedium
import br.com.fiap.elo.ui.theme.spacingSmall

@Composable
fun NivelRiscoBadge(
    nivelRisco: NivelRisco,
    modifier: Modifier = Modifier
) {
    val temaEscuro = isSystemInDarkTheme()

    val corFundo = when (nivelRisco) {
        NivelRisco.ALTO -> if (temaEscuro) RiscoAltoEscuro else RiscoAltoClaro
        NivelRisco.MEDIO -> if (temaEscuro) RiscoMedioEscuro else RiscoMedioClaro
        NivelRisco.BAIXO -> if (temaEscuro) RiscoBaixoEscuro else RiscoBaixoClaro
    }

    val corTexto = when (nivelRisco) {
        NivelRisco.ALTO -> if (temaEscuro) RiscoAltoTextoEscuro else RiscoAltoTextoClaro
        NivelRisco.MEDIO -> if (temaEscuro) RiscoMedioTextoEscuro else RiscoMedioTextoClaro
        NivelRisco.BAIXO -> if (temaEscuro) RiscoBaixoTextoEscuro else RiscoBaixoTextoClaro
    }

    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = corFundo,
        contentColor = corTexto
    ) {
        Row(
            modifier = Modifier.padding(horizontal = spacingMedium, vertical = spacingSmall),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Warning,
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(spacingSmall))
            Text(
                text = stringResource(R.string.risco, nivelRisco.label),
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NivelRiscoBadgePreview() {
    EloTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            NivelRiscoBadge(nivelRisco = NivelRisco.ALTO)
            NivelRiscoBadge(nivelRisco = NivelRisco.MEDIO)
            NivelRiscoBadge(nivelRisco = NivelRisco.BAIXO)
        }
    }
}
