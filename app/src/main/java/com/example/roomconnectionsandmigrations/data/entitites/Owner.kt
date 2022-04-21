package com.example.roomconnectionsandmigrations.data.entitites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Owners"
)
data class Owner(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name= "owner_name") val name:String,
    @ColumnInfo(name = "owner_age") val age:Int,
    @ColumnInfo(name = "owner_room_id") val roomId:Int
)