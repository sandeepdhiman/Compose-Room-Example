package com.example.mycomposeapp.di

import android.content.Context
import androidx.room.Room
import com.example.mycomposeapp.database.AppDataBase
import com.example.mycomposeapp.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DBModule {

    @Provides
    fun providesUserDao(appDataBase: AppDataBase): UserDao {
        return appDataBase.userDao()

    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context):AppDataBase{
        return Room.databaseBuilder(context,AppDataBase::class.java,"user_db").build()
    }
}