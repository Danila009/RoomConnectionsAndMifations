package com.example.roomconnectionsandmigrations.data.entitites.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomconnectionsandmigrations.data.entitites.Owner
import com.example.roomconnectionsandmigrations.data.entitites.Room

data class RoomAndOwners(
    @Embedded val room: Room,
    @Relation(
        parentColumn = "room_number",
        entityColumn = "owner_room_id"
    ) val owners:List<Owner>
)