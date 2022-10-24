package com.kismiwati.application.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kismiwati.application.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) // annotation jika ada user yang sama maka ignore
    //digunakan untuk pengguna menambahkan data
    fun addUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    //digunakan untuk membaca semua data
    fun readAllData(): LiveData<List<User>>

    @Update
    //digunakan untuk mengubah atau mengubah data
     fun updateUser(user: User)

    @Delete
    //digunakan untuk menghapus data
     fun deleteUser(User: User)

    @Query("DELETE FROM user_table")
    //digunakan untuk menghapus semua data
     fun deleteAllUser()
}