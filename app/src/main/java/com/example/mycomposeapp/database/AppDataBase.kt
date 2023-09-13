package com.example.mycomposeapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mycomposeapp.database.dao.UserDao
import com.example.mycomposeapp.database.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDataBase:RoomDatabase() {
    abstract fun userDao() : UserDao
}