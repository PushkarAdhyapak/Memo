package com.example.memo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes Table")

class Memo (@ColumnInfo(name = "text") var text: String ){

    @PrimaryKey(autoGenerate = true) var id = 0

}