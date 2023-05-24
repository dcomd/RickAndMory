package com.demo.android.alexandre.rickandmortycardapp.domain

import com.demo.android.alexandre.rickandmortycardapp.data.api.RepositoryImp
import com.demo.android.alexandre.rickandmortycardapp.data.model.CharacterList


class GetCharactersbyGenderUseCase(private val repository: RepositoryImp) {
    suspend fun invoke(params: String, page: Int): CharacterList = repository.getCharactersByGender(params, page)
}