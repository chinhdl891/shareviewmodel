package com.example.roomlivedata.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
class User(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo var name: String = "chinh",
    @ColumnInfo var old: String = "18"
)