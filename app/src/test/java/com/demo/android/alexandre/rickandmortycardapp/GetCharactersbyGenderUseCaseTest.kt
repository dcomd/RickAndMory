package com.demo.android.alexandre.rickandmortycardapp

import com.demo.android.alexandre.rickandmortycardapp.MockkData.mockkData
import com.demo.android.alexandre.rickandmortycardapp.data.api.RepositoryImp
import com.demo.android.alexandre.rickandmortycardapp.domain.GetCharactersbyGenderUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetCharactersbyGenderUseCaseTest {

    private val getCharactersbyGenderUseCase: GetCharactersbyGenderUseCase = mockk()
    private val repository: RepositoryImp = mockk()

    @Test
    fun `When call GetCharactersbyGenderUseCase must return CharacterList`() = runBlocking{
        coEvery { repository.getCharactersByGender(any(), any()) } returns mockkData()
        coEvery { getCharactersbyGenderUseCase.invoke(any(), any()) } returns mockkData()
        val getCharactersbyGenderUseCase = getCharactersbyGenderUseCase.invoke("teste", 1)
        Assert.assertEquals(mockkData().results.size, getCharactersbyGenderUseCase.results.size)
    }

}