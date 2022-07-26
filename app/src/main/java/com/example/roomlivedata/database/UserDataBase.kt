package com.example.roomlivedata.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomlivedata.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDAO(): UserDAO

    companion object {
        private var INSTANCE: UserDataBase? = null
        fun getDatabase(context: Context): UserDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDataBase::class.java,
                    "data_base"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }
}