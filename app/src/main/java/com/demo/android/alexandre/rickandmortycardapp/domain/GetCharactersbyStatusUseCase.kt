package com.demo.android.alexandre.rickandmortycardapp.domain

import com.demo.android.alexandre.rickandmortycardapp.data.api.RepositoryImp


class GetCharactersbyStatusUseCase(private val repository: RepositoryImp) {
    suspend fun invoke(params: String, page: Int) = repository.getCharactersByStatus(params, page)
}