package br.com.fiap.elo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.fiap.elo.data.repository.GolpeRepository
import br.com.fiap.elo.ui.screens.GolpeDetailScreen
import br.com.fiap.elo.ui.screens.HomeScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    val repository = remember { GolpeRepository() }

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            HomeScreen(
                repository = repository,
                onGolpeClick = { golpe ->
                    navController.navigate(Routes.detalhe(golpe.id))
                }
            )
        }

        composable(
            route = Routes.DETALHE,
            arguments = listOf(navArgument("golpeId") { type = NavType.IntType })
        ) { backStackEntry ->
            val golpeId = backStackEntry.arguments?.getInt("golpeId") ?: 0
            val golpe = repository.buscarPorId(golpeId)

            if (golpe != null) {
                GolpeDetailScreen(
                    golpe = golpe,
                    onVoltar = { navController.popBackStack() }
                )
            }
        }
    }
}
