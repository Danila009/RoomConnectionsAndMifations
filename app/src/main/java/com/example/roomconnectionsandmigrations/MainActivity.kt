package com.example.roomconnectionsandmigrations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.roomconnectionsandmigrations.di.AppComponent
import com.example.roomconnectionsandmigrations.di.DaggerAppComponent
import com.example.roomconnectionsandmigrations.ui.screen.MainScreen

class MainActivity : ComponentActivity() {

    lateinit var appComponent: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appComponent = DaggerAppComponent.builder()
            .context(this)
            .build()

        setContent {
            MainScreen(
                mainViewModel = appComponent.mainViewModel()
            )
        }
    }
}