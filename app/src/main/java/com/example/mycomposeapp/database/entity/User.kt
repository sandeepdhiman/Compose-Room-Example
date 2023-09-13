package com.example.mycomposeapp.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId : Long = 0L,
    @ColumnInfo(name = "name")
    val name :String,
    @ColumnInfo(name="mobile")
    val mobile:String,
    @ColumnInfo(name="email")
    val email:String
) {
}