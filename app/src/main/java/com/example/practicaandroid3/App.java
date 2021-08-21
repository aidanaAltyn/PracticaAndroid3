package com.example.practicaandroid3;

import android.app.Application;

import com.example.practicaandroid3.data.network.CharacterApiService;
import com.example.practicaandroid3.data.network.RetrofitClient;

public class App extends Application {
    public static CharacterApiService characterApiService;


    @Override
    public void onCreate() {
        super.onCreate();
        characterApiService = new RetrofitClient().providerCharacterApiService();
    }
}
