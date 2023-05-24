package com.demo.android.alexandre.rickandmortycardapp

import com.demo.android.alexandre.rickandmortycardapp.data.model.Character
import com.demo.android.alexandre.rickandmortycardapp.data.model.CharacterList
import com.demo.android.alexandre.rickandmortycardapp.data.model.LocationData

object MockkData {

    fun mockkData() = CharacterList(
        listOf(
            Character(
                id = 0,
                name = "John Doe",
                status = "teste",
                species = "teste",
                gender = "teste",
                origin = LocationData(name = "teste", url = "teste"),
                location = LocationData(name = "teste", url = "teste"),
                image = "teste",
                episode = listOf()
            )
        )
    )
}