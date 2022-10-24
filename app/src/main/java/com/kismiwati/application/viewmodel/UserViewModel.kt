package com.kismiwati.application.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.kismiwati.application.data.UserDatabase
import com.kismiwati.application.repository.UserRepository
import com.kismiwati.application.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(
            application
        ).userDao()
        repository =
            UserRepository(userDao)
        readAllData = repository.readAllData
    }

    //adduser berfungsi untuk menambahkan data
    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    //updateUser digunakan untuk mengubah atau mengedit data
    fun updateUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }

    //deleteuser digunakan untuk menghapus data
    fun deleteUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }

    //deletealluser digunakan untuk menghapus semua data
    fun deleteAllUser() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUser()
        }
    }
}