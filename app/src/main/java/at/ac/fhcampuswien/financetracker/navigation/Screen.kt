package at.ac.fhcampuswien.financetracker.navigation

sealed class Screen(val route: String) {
    object MainScreen : Screen(route = "mainScreen")
    object TransactionScreen : Screen(route = "transactionScreen")
}