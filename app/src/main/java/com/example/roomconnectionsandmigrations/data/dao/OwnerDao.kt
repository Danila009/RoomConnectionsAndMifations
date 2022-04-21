package com.example.roomconnectionsandmigrations.data.dao

import androidx.room.*
import com.example.roomconnectionsandmigrations.data.entitites.Owner
import com.example.roomconnectionsandmigrations.data.entitites.relations.RoomAndOwners
import kotlinx.coroutines.flow.Flow

@Dao
interface OwnerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOwner(owner: Owner)

    @Query("SELECT * FROM owners ORDER BY owner_name")
    fun getOwners():Flow<List<Owner>>

    @Transaction
    @Query("SELECT * FROM rooms WHERE id = :roomId")
    fun getOwnersByRoomId(roomId:Int):Flow<List<RoomAndOwners>>

    @Query("SELECT COUNT(id) FROM owners WHERE owner_room_id = :roomId")
    fun getOwnerCountByRoomId(roomId:Int):Flow<Int>

    @Query("DELETE FROM owners")
    suspend fun ownerClear()
}