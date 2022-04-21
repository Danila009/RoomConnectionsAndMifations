package com.example.roomconnectionsandmigrations.data.entitites.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomconnectionsandmigrations.data.entitites.Home
import com.example.roomconnectionsandmigrations.data.entitites.Room

data class HomeAndRooms(
    @Embedded val home: Home,
    @Relation(
        parentColumn = "number",
        entityColumn = "room_number_home",
        entity = Room::class
    ) val rooms:List<RoomAndOwners>
)