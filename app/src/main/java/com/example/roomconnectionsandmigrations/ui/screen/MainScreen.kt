package com.example.roomconnectionsandmigrations.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import com.example.roomconnectionsandmigrations.data.entitites.Home
import com.example.roomconnectionsandmigrations.data.entitites.relations.RoomAndOwners
import com.example.roomconnectionsandmigrations.ui.screen.viewModel.MainViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun MainScreen(
    lifecycleScope: LifecycleCoroutineScope = LocalLifecycleOwner.current.lifecycleScope,
    mainViewModel: MainViewModel
) {
    var homes by remember { mutableStateOf(listOf<Home>()) }

    lifecycleScope.launchWhenStarted {
        mainViewModel.getHomes.onEach {
            homes = it
        }.collect()
    }

    LazyColumn(content = {
        items(homes){ item ->
            var rooms by remember { mutableStateOf(listOf<RoomAndOwners>()) }

            lifecycleScope.launchWhenStarted {
                mainViewModel.getRoomsByHome(item.number).onEach {
                    rooms = it.rooms
                }.collect()
            }

            Column {
                Text(
                    text = "${item.address} / ${item.number}",
                    modifier = Modifier
                        .padding(5.dp)
                )
                LazyRow(content = {
                    items(rooms){ item ->
                        Column {
                            Text(
                                text = item.room.number.toString(),
                                modifier = Modifier
                                    .padding(5.dp)
                            )
                            repeat(item.owners.count()){ ownerCount ->
                                Text(
                                    text = item.owners[ownerCount].name,
                                    modifier = Modifier.padding(5.dp)
                                )
                            }
                        }
                    }
                })
                Divider()
            }
        }
    })
}