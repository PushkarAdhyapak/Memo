package com.example.memo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: MemoRepository
    val allMemos: LiveData<List<Memo>>

       init {
           val dao = MemoDatabase.getDatabase(application).getMemoDao()
           repository =  MemoRepository(dao)
           allMemos = repository.allMemos
       }

      fun deleteMemo(memo: Memo) = viewModelScope.launch(Dispatchers.IO) {
          repository.delete(memo)
      }

      fun insertMemo(memo: Memo) = viewModelScope.launch(Dispatchers.IO) {
          repository.insert(memo)
      }
}