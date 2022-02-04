package com.example.memo

import androidx.lifecycle.LiveData

class MemoRepository(private val memoDao: MemoDao) {

       val allMemos: LiveData<List<Memo>> = memoDao.getAllMemos()

       suspend fun insert(memo: Memo) {

           memoDao.insert(memo)

       }

    suspend fun delete(memo: Memo) {

          memoDao.delete(memo)
    }
}