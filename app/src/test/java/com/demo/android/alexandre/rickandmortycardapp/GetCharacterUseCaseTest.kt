package com.demo.android.alexandre.rickandmortycardapp

import com.demo.android.alexandre.rickandmortycardapp.data.api.RepositoryImp
import com.demo.android.alexandre.rickandmortycardapp.domain.GetCharacterUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetCharacterUseCaseTest {

    private val getCharacterUseCase: GetCharacterUseCase = mockk()
    private val repository: RepositoryImp = mockk()

    @Test
    fun `When call GetCharacterUseCase must return CharacterList`() = runBlocking{
        coEvery { repository.getCharactersByName(any()) } returns MockkData.mockkData()
        coEvery { getCharacterUseCase.invoke(any()) } returns MockkData.mockkData()
        val getCharacterUseCase = getCharacterUseCase.invoke(1)
        Assert.assertEquals(MockkData.mockkData().results.size, getCharacterUseCase.results.size)
    }
}