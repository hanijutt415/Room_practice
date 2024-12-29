package com.enfotrix.roompractice

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.Room

class UserRepository(application: Application) {
    private val userDao: UserDao
    private val db: AppDatabase = Room.databaseBuilder(application, AppDatabase::class.java, "app_database").build()

    init {
        userDao = db.userDao()
    }

    suspend fun insert(user: User) {
        userDao.insert(user)
    }

    fun getUserByCredentials(username: String, password: String): LiveData<User?> {
        return userDao.getUserByCredentials(username, password)
    }
}
