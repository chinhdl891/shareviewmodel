package com.example.roomlivedata.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.roomlivedata.model.User

@Dao
interface UserDAO {
    @Insert
    fun onInsert(user: User)

    @Delete
    fun onDelete(user: User)

    @Query("select * from user")
    fun getListUser(): LiveData<List<User>>
}