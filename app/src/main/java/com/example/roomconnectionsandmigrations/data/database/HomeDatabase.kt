package com.example.roomconnectionsandmigrations.data.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.roomconnectionsandmigrations.data.dao.HomeDao
import com.example.roomconnectionsandmigrations.data.dao.OwnerDao
import com.example.roomconnectionsandmigrations.data.dao.RoomDao
import com.example.roomconnectionsandmigrations.data.entitites.Home
import com.example.roomconnectionsandmigrations.data.entitites.Owner
import com.example.roomconnectionsandmigrations.data.entitites.Room
import com.example.roomconnectionsandmigrations.data.migrations.MigrationTo1From2BitmapOwnerDelete
import com.example.roomconnectionsandmigrations.data.typeConverters.PhotoTypeConverter

@Database(
    entities = [
        Home::class,
        Room::class,
        Owner::class
    ], version = 4,
    autoMigrations = [
        AutoMigration(
            from = 2,
            to = 3,
            spec = MigrationTo1From2BitmapOwnerDelete::class
        )
    ]
)
@TypeConverters(
    value = [
        PhotoTypeConverter::class
    ]
)
abstract class HomeDatabase : RoomDatabase() {
    abstract fun homeDao():HomeDao
    abstract fun roomDao():RoomDao
    abstract fun ownerDao():OwnerDao
}