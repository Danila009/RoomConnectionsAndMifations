package com.example.roomconnectionsandmigrations.data.repository

import com.example.roomconnectionsandmigrations.data.dao.HomeDao
import com.example.roomconnectionsandmigrations.data.entitites.Home
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val homeDao: HomeDao
) {
    suspend fun insertHome(home: Home) {
        homeDao.insertHome(home)
    }

    fun getHomes(): Flow<List<Home>> {
        return homeDao.getHomes()
    }

    suspend fun clearHome(){
        homeDao.clearHome()
    }
}