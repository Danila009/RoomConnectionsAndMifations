package com.example.roomconnectionsandmigrations.di

import android.content.Context
import androidx.room.Room
import com.example.roomconnectionsandmigrations.data.dao.HomeDao
import com.example.roomconnectionsandmigrations.data.dao.OwnerDao
import com.example.roomconnectionsandmigrations.data.dao.RoomDao
import com.example.roomconnectionsandmigrations.data.database.HomeDatabase
import com.example.roomconnectionsandmigrations.data.migrations.MigrationTo3From4OwnerAgeAddColumn
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun providerHomeDatabase(
        context: Context
    ):HomeDatabase = Room
        .databaseBuilder(
            context.applicationContext,
            HomeDatabase::class.java,
            "home_database"
        )
        .addMigrations(
            MigrationTo3From4OwnerAgeAddColumn
        ).build()

    @Provides
    @Singleton
    fun providerHomeDao(
        homeDatabase: HomeDatabase
    ):HomeDao = homeDatabase.homeDao()

    @Provides
    @Singleton
    fun providerRoomDao(
        homeDatabase: HomeDatabase
    ):RoomDao = homeDatabase.roomDao()

    @Provides
    @Singleton
    fun providerOwnerDao(
        homeDatabase: HomeDatabase
    ):OwnerDao = homeDatabase.ownerDao()
}