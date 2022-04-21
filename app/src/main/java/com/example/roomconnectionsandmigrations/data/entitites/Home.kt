package com.example.roomconnectionsandmigrations.data.entitites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Homes"
)
data class Home(
    @PrimaryKey(autoGenerate = false) val number:String,
    @ColumnInfo(name = "home_address") val address:String
)