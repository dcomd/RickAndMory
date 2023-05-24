package com.demo.android.alexandre.rickandmortycardapp.domain

import com.demo.android.alexandre.rickandmortycardapp.data.api.RepositoryImp



class GetCharactersbyStatusAndGenderUseCase(private val repository: RepositoryImp) {
    suspend fun invoke(params: String, gender: String, page: Int) =
        repository.getCharactersbyStatusAndGender(params, gender, page)
}