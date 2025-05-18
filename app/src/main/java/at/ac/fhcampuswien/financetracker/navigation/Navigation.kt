package at.ac.fhcampuswien.financetracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import at.ac.fhcampuswien.financetracker.presentation.MainScreen
import at.ac.fhcampuswien.financetracker.presentation.TransactionScreen

@Composable
fun Navigation(modifier: Modifier) {
    val controller = rememberNavController()

    NavHost(navController = controller, startDestination = Screen.MainScreen.route) {
        // Main Screen
        composable(route = Screen.MainScreen.route) {
            MainScreen(modifier = modifier, navController = controller)
        }

        // Transactions
        composable(route = Screen.TransactionScreen.route) {
            TransactionScreen(modifier = modifier, navController = controller)
        }
    }
}