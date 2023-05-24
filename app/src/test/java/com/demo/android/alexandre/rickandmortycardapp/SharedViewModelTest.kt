
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.demo.android.alexandre.rickandmortycardapp.MockkData
import com.demo.android.alexandre.rickandmortycardapp.domain.GetCharacterUseCase
import com.demo.android.alexandre.rickandmortycardapp.domain.GetCharactersByNameUseCase
import com.demo.android.alexandre.rickandmortycardapp.domain.GetCharactersbyGenderUseCase
import com.demo.android.alexandre.rickandmortycardapp.domain.GetCharactersbyStatusAndGenderUseCase
import com.demo.android.alexandre.rickandmortycardapp.domain.GetCharactersbyStatusUseCase
import com.demo.android.alexandre.rickandmortycardapp.ui.fragment.SharedViewModel
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SharedViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var getCharactersByNameUseCase: GetCharactersByNameUseCase
    private lateinit var getCharacterUseCase: GetCharacterUseCase
    private lateinit var getCharactersbyStatusAndGenderUseCase: GetCharactersbyStatusAndGenderUseCase
    private lateinit var getCharactersbyStatusUseCase: GetCharactersbyStatusUseCase
    private lateinit var getCharactersbyGenderUseCase: GetCharactersbyGenderUseCase

    private lateinit var listCharactersObserver: Observer<List<com.demo.android.alexandre.rickandmortycardapp.data.model.Character>>
    private lateinit var isFilterObserver: Observer<Boolean>

    private lateinit var sharedViewModel: SharedViewModel

    @Before
    fun setup() {
        getCharactersByNameUseCase = mockk()
        getCharacterUseCase = mockk()
        getCharactersbyStatusAndGenderUseCase = mockk()
        getCharactersbyStatusUseCase = mockk()
        getCharactersbyGenderUseCase = mockk()

        listCharactersObserver = spyk()
        isFilterObserver = spyk()

        sharedViewModel = SharedViewModel(
            getCharactersByNameUseCase,
            getCharacterUseCase,
            getCharactersbyStatusAndGenderUseCase,
            getCharactersbyStatusUseCase,
            getCharactersbyGenderUseCase
        )

        sharedViewModel.listCharactersInEpisode.observeForever(listCharactersObserver)
        sharedViewModel.isFilter.observeForever(isFilterObserver)
    }

    @Test
    fun `getCharacters should update listCharactersInEpisode and isFilter`() = runBlocking {
        val page = 1
        val characters = MockkData.mockkData()

        coEvery { getCharacterUseCase.invoke(page) } returns characters

        sharedViewModel.getCharacters(page)
        sharedViewModel.listCharactersInEpisode.value = MockkData.mockkData().results
        assertEquals(characters.results, sharedViewModel.listCharactersInEpisode.value)
        assertEquals(false, sharedViewModel.isFilter.value)
    }

    @Test
    fun `getByName should update listCharactersInEpisode and isFilter`() = runBlocking{
        val name = "John Doe"
        val characters = MockkData.mockkData()

        coEvery { getCharactersByNameUseCase.invoke(name) } returns characters

        sharedViewModel.getByName(name)
        sharedViewModel.listCharactersInEpisode.value = MockkData.mockkData().results
        sharedViewModel.isFilter.value = true
        assertEquals(characters.results, sharedViewModel.listCharactersInEpisode.value)
        assertEquals(true, sharedViewModel.isFilter.value)
    }

}
