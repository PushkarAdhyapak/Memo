package com.example.memo


import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MemoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(memo: Memo)

    @Delete
    suspend fun  delete(memo: Memo)

    @Query("Select * from `notes table` order by id ASC")
    fun getAllMemos() : LiveData<List<Memo>>

}