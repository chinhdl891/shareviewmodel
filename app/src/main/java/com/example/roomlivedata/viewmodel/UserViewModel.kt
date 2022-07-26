package com.example.roomlivedata.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.roomlivedata.database.UserDataBase
import com.example.roomlivedata.model.User

class UserViewModel(application: Application) : AndroidViewModel(application) {

    val userDAO = UserDataBase.getDatabase(getApplication()).userDAO()
    lateinit var listUser: LiveData<List<User>>
    val content: MutableLiveData<String> = MutableLiveData("")
    fun getListUser() {
        listUser = userDAO.getListUser()
    }

    fun setContent(s: String) {
        content.value = s
    }
}