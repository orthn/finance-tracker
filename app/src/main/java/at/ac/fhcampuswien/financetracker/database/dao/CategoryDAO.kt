package at.ac.fhcampuswien.financetracker.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import at.ac.fhcampuswien.financetracker.database.Category

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(category: Category)

    @Query("SELECT * FROM categories")
    fun getAllCategories(): LiveData<List<Category>>
}