package com.kismiwati.application.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
//Anotasi parcelable untuk membuat objek parcelable
@Parcelize
//Anotasi entitas untuk menentukan nama tabel
@Entity(tableName = "user_table")
data class User(
    //Anotasi PrimaryKey untuk mendeklarasikan kunci utama dengan nilai kenaikan otomatis
    @PrimaryKey(autoGenerate = true)
    //menunjukan entity atau kolom yang digunakan pada tabel, ada kolom id, firstname, lastname dan age
    val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int
) : Parcelable