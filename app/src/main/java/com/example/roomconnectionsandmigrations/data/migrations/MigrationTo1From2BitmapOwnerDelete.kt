package com.example.roomconnectionsandmigrations.data.migrations

import androidx.room.DeleteColumn
import androidx.room.migration.AutoMigrationSpec

@DeleteColumn(
    tableName = "Owners",
    columnName = "owner_photo"
)
class MigrationTo1From2BitmapOwnerDelete : AutoMigrationSpec