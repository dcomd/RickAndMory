package com.demo.android.alexandre.rickandmortycardapp.data.api

import com.demo.android.alexandre.rickandmortycardapp.data.model.CharacterList

class RepositoryImp: Repository {
    
    override suspend fun getCharacters(page: Int): CharacterList {
        return RetrofitInstance.api.getCharacters(page)
    }

   override suspend fun getCharactersByName(name: String): CharacterList {
        return RetrofitInstance.api.getCharactersByName(name)
    }

    override suspend fun getCharactersbyStatusAndGender(status : String, gender: String, page:Int): CharacterList {
        return RetrofitInstance.api.getCharactersbyStatusAndGender(status, gender, page)
    }

   override suspend fun getCharactersByStatus(status : String, page:Int): CharacterList {
        return RetrofitInstance.api.getCharactersByStatus(status, page)
    }

    override suspend fun getCharactersByGender(gender : String, page:Int): CharacterList {
        return RetrofitInstance.api.getCharactersByGender(gender, page)
    }
}