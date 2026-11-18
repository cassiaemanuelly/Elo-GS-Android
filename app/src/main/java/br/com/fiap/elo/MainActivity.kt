package br.com.fiap.elo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.fiap.elo.navigation.AppNavigation
import br.com.fiap.elo.ui.theme.EloTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EloTheme {
                AppNavigation()
            }
        }
    }
}
