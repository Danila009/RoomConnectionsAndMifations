package com.example.roomconnectionsandmigrations.data.repository

import com.example.roomconnectionsandmigrations.data.dao.RoomDao
import com.example.roomconnectionsandmigrations.data.entitites.Room
import com.example.roomconnectionsandmigrations.data.entitites.relations.HomeAndRooms
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoomRepository @Inject constructor(
    private val roomDao: RoomDao
){
    suspend fun insertRoom(room: Room) {
        return roomDao.insertRoom(room)
    }

    fun getNumbers(): Flow<List<Room>> {
        return roomDao.getRooms()
    }

    fun getRoomsByHome(numberHome:String):Flow<HomeAndRooms>{
        return roomDao.getRoomsByHome(
            numberHome = numberHome
        )
    }

    suspend fun clearRoom(){
        roomDao.clearRoom()
    }
}