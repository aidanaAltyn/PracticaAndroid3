package com.example.practicaandroid3.data.network;

import com.example.practicaandroid3.models.CharacterM;
import com.example.practicaandroid3.models.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CharacterApiService {
    @GET("api/character")
    Call<RickAndMortyResponse<CharacterM>> fetchCharacter();
    @GET("api/character/{id}")
    Call<CharacterM> fetchCharacterId(@Path("id")int id);
}
