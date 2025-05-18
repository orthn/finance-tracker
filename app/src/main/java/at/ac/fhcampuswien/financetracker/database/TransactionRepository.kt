package at.ac.fhcampuswien.financetracker.database

import androidx.lifecycle.LiveData
import at.ac.fhcampuswien.financetracker.database.dao.CategoryDao
import at.ac.fhcampuswien.financetracker.database.dao.TransactionDao

class TransactionRepository(
    private val transactionDao: TransactionDao,
    private val categoryDao: CategoryDao
) {
    val allTransactions: LiveData<List<Transaction>> = transactionDao.getAllTransactions()
    val allCategories: LiveData<List<Category>> = categoryDao.getAllCategories()

    suspend fun insertTransaction(transaction: Transaction) {
        transactionDao.insert(transaction)
    }

    suspend fun insertCategory(category: Category) {
        categoryDao.insert(category)
    }

    fun getTransactionsForCategory(categoryId: Int) =
        transactionDao.getTransactionsForCategory(categoryId)
}