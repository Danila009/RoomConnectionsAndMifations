package com.example.roomconnectionsandmigrations.ui.screen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomconnectionsandmigrations.data.entitites.Home
import com.example.roomconnectionsandmigrations.data.entitites.Owner
import com.example.roomconnectionsandmigrations.data.entitites.Room
import com.example.roomconnectionsandmigrations.data.entitites.relations.HomeAndRooms
import com.example.roomconnectionsandmigrations.data.repository.HomeRepository
import com.example.roomconnectionsandmigrations.data.repository.OwnerRepository
import com.example.roomconnectionsandmigrations.data.repository.RoomRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val homeRepository: HomeRepository,
    private val ownerRepository: OwnerRepository,
    private val roomRepository: RoomRepository
):ViewModel() {
    val getHomes = homeRepository.getHomes()

    init {
        repeat(10){ homeTime ->
            insertHome(
                Home(
                    number = homeTime.toString(),
                    address = "Ленина, ${(1..200).random()}"
                )
            )
            repeat(10){ roomTime ->
                insertRoom(
                    Room(
                        id = roomTime,
                        number = (1..300).random(),
                        numberHome = homeTime.toString()
                    )
                )
                repeat(3){
                    insertOwner(
                        Owner(
                            id = 0,
                            name = "Danila_${(1..100).random()}",
                            roomId = roomTime,
                            age = (1..20).random()
                        )
                    )
                }
            }
        }
    }

    fun getRoomsByHome(numberHome:String):Flow<HomeAndRooms>{
        return roomRepository.getRoomsByHome(numberHome = numberHome)
    }

    private fun insertHome(home: Home){
        viewModelScope.launch {
            homeRepository.insertHome(home)
        }
    }

    private fun insertRoom(room:Room){
        viewModelScope.launch {
            roomRepository.insertRoom(room)
        }
    }

    private fun insertOwner(owner: Owner){
        viewModelScope.launch {
            ownerRepository.insertOwner(owner)
        }
    }

    private fun clearHome(){
        viewModelScope.launch {
            homeRepository.clearHome()
        }
    }

    private fun clearRoom(){
        viewModelScope.launch {
            roomRepository.clearRoom()
        }
    }

    private fun ownerClear(){
        viewModelScope.launch {
            ownerRepository.ownerClear()
        }
    }

    override fun onCleared() {
        super.onCleared()
        clearHome()
        clearRoom()
        ownerClear()
    }
}