package com.example.practicafinal

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {


    @Query("SELECT * FROM user WHERE usuario = :usuario AND pass = :pass")
    fun getUser(usuario: String, pass: String): User?

    @Insert
    fun insertUser(user: User)
}