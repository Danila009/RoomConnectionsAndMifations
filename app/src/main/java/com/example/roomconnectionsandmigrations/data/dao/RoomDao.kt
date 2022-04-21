package com.example.roomconnectionsandmigrations.data.dao

import androidx.room.*
import com.example.roomconnectionsandmigrations.data.entitites.relations.HomeAndRooms
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRoom(room: com.example.roomconnectionsandmigrations.data.entitites.Room)

    @Query("SELECT * FROM rooms ORDER BY room_number")
    fun getRooms():Flow<List<com.example.roomconnectionsandmigrations.data.entitites.Room>>

    @Transaction
    @Query("SELECT * FROM homes WHERE number = :numberHome")
    fun getRoomsByHome(numberHome:String):Flow<HomeAndRooms>

    @Query("SELECT COUNT(id) FROM rooms WHERE room_number_home = :homeNumber")
    fun getCountRoomByHomeNumber(homeNumber:String):Flow<Int>

    @Query("DELETE FROM rooms")
    suspend fun clearRoom()
}