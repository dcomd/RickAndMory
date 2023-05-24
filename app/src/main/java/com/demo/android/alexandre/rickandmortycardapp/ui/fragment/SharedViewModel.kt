package com.demo.android.alexandre.rickandmortycardapp.ui.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.android.alexandre.rickandmortycardapp.data.model.Character
import com.demo.android.alexandre.rickandmortycardapp.domain.GetCharacterUseCase
import com.demo.android.alexandre.rickandmortycardapp.domain.GetCharactersByNameUseCase
import com.demo.android.alexandre.rickandmortycardapp.domain.GetCharactersbyGenderUseCase
import com.demo.android.alexandre.rickandmortycardapp.domain.GetCharactersbyStatusAndGenderUseCase
import com.demo.android.alexandre.rickandmortycardapp.domain.GetCharactersbyStatusUseCase
import kotlinx.coroutines.launch

class SharedViewModel(
    private val getCaracterUseCase: GetCharactersByNameUseCase,
    private val getCharacterUseCase : GetCharacterUseCase,
    private val getCharactersbyStatusAndGenderUseCase: GetCharactersbyStatusAndGenderUseCase,
    private val getCharactersbyStatusUseCase: GetCharactersbyStatusUseCase,
    private val getCharactersbyGenderUseCase: GetCharactersbyGenderUseCase
): ViewModel() {

    var listCharactersInEpisode = MutableLiveData<List<Character>>()
    var filterValue = MutableLiveData<Array<Int>>()
    var isFilter = MutableLiveData<Boolean>()

    init {
        filterValue.value = arrayOf(0, 0)
        isFilter.value = false
    }

    fun getCharacters(page: Int) {
        viewModelScope.launch{
            val characters = getCharacterUseCase.invoke(page)
            listCharactersInEpisode.value = characters.results
            isFilter.value = false
        }
    }

    fun getByName(name: String){
        viewModelScope.launch{
            val characters = getCaracterUseCase.invoke(name)
            listCharactersInEpisode.value = characters.results
            isFilter.value = true
        }
    }

    fun getByStatusAndGender(status : String, gender: String, page:Int){
        viewModelScope.launch{
            val characters = getCharactersbyStatusAndGenderUseCase.invoke(status, gender, page)
            listCharactersInEpisode.value = characters.results
            isFilter.value = true
        }
    }

    fun getByStatus(status : String, page:Int){
        viewModelScope.launch{
            val characters = getCharactersbyStatusUseCase.invoke(status, page)
            listCharactersInEpisode.value = characters.results
            isFilter.value = true
        }
    }

    fun getByGender(gender: String, page:Int){
        viewModelScope.launch{
            val characters = getCharactersbyGenderUseCase.invoke(gender, page)
            listCharactersInEpisode.value = characters.results
            isFilter.value = true
        }
    }


}