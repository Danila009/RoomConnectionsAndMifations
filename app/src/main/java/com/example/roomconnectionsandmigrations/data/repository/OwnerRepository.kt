package com.example.roomconnectionsandmigrations.data.repository

import com.example.roomconnectionsandmigrations.data.dao.OwnerDao
import com.example.roomconnectionsandmigrations.data.entitites.Owner
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OwnerRepository @Inject constructor(
    private val ownerDao: OwnerDao
) {
    suspend fun insertOwner(owner: Owner) {
        ownerDao.insertOwner(owner)
    }

    fun getOwners(): Flow<List<Owner>> {
        return ownerDao.getOwners()
    }

    suspend fun ownerClear(){
        ownerDao.ownerClear()
    }
}