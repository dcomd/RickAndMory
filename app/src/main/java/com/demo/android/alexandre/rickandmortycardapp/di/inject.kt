package com.demo.android.alexandre.rickandmortycardapp.di

import com.demo.android.alexandre.rickandmortycardapp.data.api.RepositoryImp
import com.demo.android.alexandre.rickandmortycardapp.domain.GetCharacterUseCase
import com.demo.android.alexandre.rickandmortycardapp.domain.GetCharactersByNameUseCase
import com.demo.android.alexandre.rickandmortycardapp.domain.GetCharactersbyGenderUseCase
import com.demo.android.alexandre.rickandmortycardapp.domain.GetCharactersbyStatusAndGenderUseCase
import com.demo.android.alexandre.rickandmortycardapp.domain.GetCharactersbyStatusUseCase
import com.demo.android.alexandre.rickandmortycardapp.ui.fragment.SharedViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single { RepositoryImp() }
    factory { GetCharactersbyGenderUseCase(get()) }
    factory { GetCharactersbyStatusUseCase(get()) }
    factory { GetCharacterUseCase(get()) }
    factory { GetCharactersByNameUseCase(get()) }
    factory { GetCharactersbyStatusAndGenderUseCase(get()) }
    viewModel{SharedViewModel(get(), get(), get(), get(), get())}
}