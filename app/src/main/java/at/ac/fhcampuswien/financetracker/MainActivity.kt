package at.ac.fhcampuswien.financetracker

import TransactionViewModelFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import at.ac.fhcampuswien.financetracker.database.Category
import at.ac.fhcampuswien.financetracker.database.AppDatabase
import at.ac.fhcampuswien.financetracker.database.Transaction
import at.ac.fhcampuswien.financetracker.database.TransactionRepository
import at.ac.fhcampuswien.financetracker.navigation.Navigation
import at.ac.fhcampuswien.financetracker.ui.theme.FinanceTrackerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val db = AppDatabase.getDatabase(applicationContext)
        val repository = TransactionRepository(db.transactionDao(), db.categoryDao())
        val factory = TransactionViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[TransactionViewModel::class.java]

        // Sample insert
        val sampleCategory = Category(name = "Food", type = "expense")
        val sampleTransaction = Transaction(amount = 10.0f, description = "Lunch", timestamp = System.currentTimeMillis(), categoryId = 1)

        lifecycleScope.launch {
            viewModel.insertCategory(sampleCategory)
            viewModel.insertTransaction(sampleTransaction)
        }

        enableEdgeToEdge()
        setContent {
            FinanceTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Navigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}