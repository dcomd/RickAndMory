package com.demo.android.alexandre.rickandmortycardapp

import com.demo.android.alexandre.rickandmortycardapp.data.api.RepositoryImp
import com.demo.android.alexandre.rickandmortycardapp.domain.GetCharactersbyStatusAndGenderUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetCharactersbyStatusAndGenderUseCaseTest {

    private val getCharactersbyStatusAndGenderUseCase: GetCharactersbyStatusAndGenderUseCase = mockk()
    private val repository: RepositoryImp = mockk()

    @Test
    fun `When call GetCharactersbyStatusAndGenderUseCase must return CharacterList`() = runBlocking{
        coEvery { repository.getCharactersByName(any()) } returns MockkData.mockkData()
        coEvery { getCharactersbyStatusAndGenderUseCase.invoke(any(), any(), any()) } returns MockkData.mockkData()
        val getCharactersbyStatusAndGenderUseCase = getCharactersbyStatusAndGenderUseCase.invoke("teste", "teste", 1)
        Assert.assertEquals(MockkData.mockkData().results.size, getCharactersbyStatusAndGenderUseCase.results.size)
    }
}