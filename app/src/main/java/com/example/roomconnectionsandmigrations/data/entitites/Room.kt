package com.example.roomconnectionsandmigrations.data.entitites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Rooms"
)
data class Room(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "room_number") val number:Int,
    @ColumnInfo(name = "room_number_home") val numberHome:String
)