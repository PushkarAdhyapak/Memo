package com.example.memo

import android.content.Context
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Memo::class), version = 1, exportSchema = false)
abstract class MemoDatabase: RoomDatabase() {

    abstract fun getMemoDao(): MemoDao

    companion object {

        @Volatile
        private var INSTANCE: MemoDatabase? = null

        fun getDatabase(context: Context): MemoDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MemoDatabase::class.java,
                    "memo_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

    }


}