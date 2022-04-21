package com.example.roomconnectionsandmigrations.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomconnectionsandmigrations.data.entitites.Home
import kotlinx.coroutines.flow.Flow

@Dao
interface HomeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertHome(home: Home)

    @Query("SELECT * FROM homes ORDER BY number")
    fun getHomes():Flow<List<Home>>

    @Query("SELECT COUNT(number) FROM homes")
    fun getHomeCount():Flow<Int>

    @Query("DELETE  FROM homes")
    suspend fun clearHome()
}