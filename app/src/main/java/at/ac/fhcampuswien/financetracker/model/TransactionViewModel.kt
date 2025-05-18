import androidx.lifecycle.*
import at.ac.fhcampuswien.financetracker.database.Category
import at.ac.fhcampuswien.financetracker.database.Transaction
import at.ac.fhcampuswien.financetracker.database.TransactionRepository
import kotlinx.coroutines.launch

class TransactionViewModel(private val repository: TransactionRepository) : ViewModel() {
    val allTransactions: LiveData<List<Transaction>> = repository.allTransactions
    val allCategories: LiveData<List<Category>> = repository.allCategories

    fun insertTransaction(transaction: Transaction) = viewModelScope.launch {
        repository.insertTransaction(transaction)
    }

    fun insertCategory(category: Category) = viewModelScope.launch {
        repository.insertCategory(category)
    }

    fun getTransactionsForCategory(categoryId: Int) =
        repository.getTransactionsForCategory(categoryId)
}