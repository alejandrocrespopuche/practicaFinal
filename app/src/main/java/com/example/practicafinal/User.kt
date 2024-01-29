package com.example.practicafinal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
    data class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "usuario") val usuario: String?,
    @ColumnInfo(name = "pass") val pass: String?
    )
