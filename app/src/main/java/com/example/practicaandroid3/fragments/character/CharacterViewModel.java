package com.example.practicaandroid3.fragments.character;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.practicaandroid3.App;
import com.example.practicaandroid3.models.CharacterM;
import com.example.practicaandroid3.models.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterViewModel extends ViewModel {
    MutableLiveData<RickAndMortyResponse<CharacterM>> data = new MutableLiveData<>();

    MutableLiveData<RickAndMortyResponse<CharacterM>> fetchCharacter(){
        App.characterApiService.fetchCharacter().enqueue(new Callback<RickAndMortyResponse<CharacterM>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<CharacterM>> call, Response<RickAndMortyResponse<CharacterM>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<CharacterM>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

}
