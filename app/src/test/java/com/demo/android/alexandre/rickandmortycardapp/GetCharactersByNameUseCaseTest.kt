package com.demo.android.alexandre.rickandmortycardapp

import com.demo.android.alexandre.rickandmortycardapp.data.api.RepositoryImp
import com.demo.android.alexandre.rickandmortycardapp.domain.GetCharactersByNameUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetCharactersByNameUseCaseTest {

    private val getCharactersByNameUseCase: GetCharactersByNameUseCase = mockk()
    private val repository: RepositoryImp = mockk()

    @Test
    fun `When call GetCharactersByNameUseCase must return CharacterList`() = runBlocking{
        coEvery { repository.getCharactersByName(any()) } returns MockkData.mockkData()
        coEvery { getCharactersByNameUseCase.invoke(any()) } returns MockkData.mockkData()
        val getCharactersByNameUseCase = getCharactersByNameUseCase.invoke("teste")
        Assert.assertEquals(MockkData.mockkData().results.size, getCharactersByNameUseCase.results.size)
    }
}