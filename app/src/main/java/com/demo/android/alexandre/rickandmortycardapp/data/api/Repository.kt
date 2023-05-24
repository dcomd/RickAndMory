package com.demo.android.alexandre.rickandmortycardapp.data.api

import com.demo.android.alexandre.rickandmortycardapp.data.model.CharacterList

interface Repository {

    suspend fun getCharacters(page: Int): CharacterList

    suspend fun getCharactersByName(name: String): CharacterList

    suspend fun getCharactersbyStatusAndGender(status : String, gender: String, page:Int): CharacterList

    suspend fun getCharactersByStatus(status : String, page:Int): CharacterList

    suspend fun getCharactersByGender(gender : String, page:Int): CharacterList
}