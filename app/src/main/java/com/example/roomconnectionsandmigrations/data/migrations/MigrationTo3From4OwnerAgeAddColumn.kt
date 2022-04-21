package com.example.roomconnectionsandmigrations.data.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MigrationTo3From4OwnerAgeAddColumn  = object :Migration(3,4){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE Owners ADD owner_age INT")
    }
}