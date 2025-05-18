package at.ac.fhcampuswien.financetracker.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import at.ac.fhcampuswien.financetracker.database.Transaction

@Dao
interface TransactionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(transaction: Transaction)

    @Query("SELECT * FROM transactions")
    fun getAllTransactions(): LiveData<List<Transaction>>

    @Query("SELECT * FROM transactions WHERE categoryId = :categoryId")
    fun getTransactionsForCategory(categoryId: Int): LiveData<List<Transaction>>
}