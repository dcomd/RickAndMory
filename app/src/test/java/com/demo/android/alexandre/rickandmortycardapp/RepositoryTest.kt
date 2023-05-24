package com.demo.android.alexandre.rickandmortycardapp


import com.demo.android.alexandre.rickandmortycardapp.MockkData.mockkData
import com.demo.android.alexandre.rickandmortycardapp.data.api.RepositoryImp
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class RepositoryTest {

    private var repository: RepositoryImp = mockk()


    @Test
    fun `getCharacters should return character list`() = runBlocking {
        coEvery { repository.getCharacters(any()) } returns mockkData()
        val page = 1
        val characterList = repository.getCharacters(page)
        assertEquals(mockkData().results.size, characterList.results.size)
    }

    @Test
    fun `getCharactersByName should return character list`() = runBlocking {
        coEvery { repository.getCharactersByName(any()) } returns mockkData()
        val name = "John Doe"
        val characterList = repository.getCharactersByName(name)
        assertEquals("John Doe", characterList.results.first().name)
    }

    @Test
    fun `getCharactersByStatusAndGender should return character list`() = runBlocking {
        coEvery { repository.getCharactersbyStatusAndGender(any(), any(), any()) } returns mockkData()
        val status = "alive"
        val gender = "male"
        val page = 1
        val characterList = repository.getCharactersbyStatusAndGender(status, gender, page)
        assertEquals(mockkData().results.size, characterList.results.size)
    }

    @Test
    fun `getCharactersByStatus should return character list`() = runBlocking {
        coEvery { repository.getCharactersByStatus(any(), any()) } returns mockkData()
        val status = "alive"
        val page = 1
        val characterList = repository.getCharactersByStatus(status, page)
        assertEquals(mockkData().results.size, characterList.results.size)
    }

    @Test
    fun `getCharactersByGender should return character list`() = runBlocking {
        coEvery { repository.getCharactersByGender(any(), any()) } returns mockkData()
        val gender = "male"
        val page = 1
        val characterList = repository.getCharactersByGender(gender, page)
        assertEquals(mockkData().results.size, characterList.results.size)
    }

}