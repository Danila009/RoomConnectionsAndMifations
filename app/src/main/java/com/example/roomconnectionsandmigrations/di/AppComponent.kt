package com.example.roomconnectionsandmigrations.di

import android.content.Context
import com.example.roomconnectionsandmigrations.ui.screen.viewModel.MainViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        DatabaseModule::class
    ]
)
@Singleton
interface AppComponent {

    fun mainViewModel():MainViewModel

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun context(context: Context):Builder

        fun build():AppComponent
    }
}