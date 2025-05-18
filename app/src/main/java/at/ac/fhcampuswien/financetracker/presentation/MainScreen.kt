package at.ac.fhcampuswien.financetracker.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import at.ac.fhcampuswien.financetracker.navigation.Screen

@Composable
fun MainScreen(
    modifier: Modifier, navController: NavController
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("This is the Main Screen")
        Button(
            onClick = { navController.navigate(Screen.TransactionScreen.route)},
            modifier = Modifier.fillMaxWidth(0.6f),
            shape = MaterialTheme.shapes.medium
        ) {
            Text("View Transactions")
        }
    }
}