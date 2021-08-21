package com.example.practicaandroid3.fragments.character;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practicaandroid3.OnItemClickListener;
import com.example.practicaandroid3.databinding.FragmentCharacterBinding;
import com.example.practicaandroid3.databinding.FragmentDetailCharacterBinding;
import com.example.practicaandroid3.fragments.character.adapter.CharacterAdapter;
import com.example.practicaandroid3.models.CharacterM;
import com.example.practicaandroid3.models.RickAndMortyResponse;


public class CharacterFragment extends Fragment {
    private CharacterViewModel viewModel;
    private CharacterAdapter characterAdapter;
    private FragmentCharacterBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        characterAdapter = new CharacterAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCharacterBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initilithation();
        setupRecycler();
        setupRequest();
    }


    private void initilithation() {
        viewModel = new ViewModelProvider(requireActivity()).get(CharacterViewModel.class);
    }
    private void setupRecycler() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(characterAdapter);
        characterAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClickItem(int position) {

            }
        });
    }
    private void setupRequest() {
        viewModel.fetchCharacter().observe(getViewLifecycleOwner(), character -> {
            characterAdapter.addData(character.getResults());
        });
    }
}