package com.demo.android.alexandre.rickandmortycardapp

import com.demo.android.alexandre.rickandmortycardapp.data.api.RepositoryImp
import com.demo.android.alexandre.rickandmortycardapp.domain.GetCharactersbyStatusUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetCharactersbyStatusUseCaseTest {

    private val getCharactersbyStatusUseCase: GetCharactersbyStatusUseCase = mockk()
    private val repository: RepositoryImp = mockk()

    @Test
    fun `When call GetCharactersbyStatusUseCase must return CharacterList`() = runBlocking{
        coEvery { repository.getCharactersByName(any()) } returns MockkData.mockkData()
        coEvery { getCharactersbyStatusUseCase.invoke(any(), any()) } returns MockkData.mockkData()
        val getCharactersbyStatusUseCase = getCharactersbyStatusUseCase.invoke("teste", 1)
        Assert.assertEquals(MockkData.mockkData().results.size, getCharactersbyStatusUseCase.results.size)
    }
}