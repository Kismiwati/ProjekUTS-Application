package com.kismiwati.application.repository

import androidx.lifecycle.LiveData
import com.kismiwati.application.data.UserDao
import com.kismiwati.application.model.User

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    //addUser digunakan untuk menambahkan data
     fun addUser(user: User) {
        userDao.addUser(user)
    }

    //updateUser digunakan untuk mengubah atau mengedit data
     fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    //deleteUser digunakan untuk menghapus data
     fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    //deleteAllUser digunakan untuk menghapus semua data
     fun deleteAllUser() {
        userDao.deleteAllUser()
    }
}