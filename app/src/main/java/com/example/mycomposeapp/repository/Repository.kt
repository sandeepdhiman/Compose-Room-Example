package com.example.mycomposeapp.repository

import com.example.mycomposeapp.database.dao.UserDao
import com.example.mycomposeapp.database.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
class Repository @Inject constructor(private val userDao: UserDao) {

    val allUsers :Flow<List<User>> = userDao.getAllUsers()

    suspend fun insertRecord(user: User){
        withContext(Dispatchers.IO){
            userDao.insert(user)
        }
    }


}