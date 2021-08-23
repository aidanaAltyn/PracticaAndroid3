package com.example.practicaandroid3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.practicaandroid3.databinding.ActivityMainBinding;
import com.example.practicaandroid3.databinding.FragmentLokation2Binding;
import com.example.practicaandroid3.fragments.character.CharacterFragment;
import com.example.practicaandroid3.fragments.episode.EpisodeFragment;
import com.example.practicaandroid3.fragments.location.LocationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private NavController navController;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setB();
        setupNavigation();
        setContentView(binding.getRoot());
    }


    private void setB() {
        binding.navigat.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()) {
                    case R.id.page_1:
                        transaction.replace(R.id.nav_host_fragment, new CharacterFragment()).commit();
                        return true;
                    case R.id.page_2:
                        transaction.replace(R.id.nav_host_fragment, new LocationFragment()).commit();
                        return true;
                    case R.id.page_3:
                        transaction.replace(R.id.nav_host_fragment, new EpisodeFragment()).commit();
                        return true;
                }
                return false;
            }
        });

        }


    private void setupNavigation() {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
    }
}