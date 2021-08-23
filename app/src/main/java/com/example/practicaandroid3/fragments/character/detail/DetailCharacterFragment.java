package com.example.practicaandroid3.fragments.character.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.practicaandroid3.R;
import com.example.practicaandroid3.databinding.FragmentDetailCharacterBinding;
import com.example.practicaandroid3.fragments.character.CharacterFragment;
import com.example.practicaandroid3.fragments.character.CharacterViewModel;
import com.example.practicaandroid3.models.CharacterM;


public class DetailCharacterFragment extends Fragment {
    private FragmentDetailCharacterBinding binding;
    private CharacterViewModel viewModel;
    private int id;


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        binding = FragmentDetailCharacterBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialization();
        setupArgs();
        setupRequest();
    }

    private void initialization() {
        viewModel = new ViewModelProvider(requireActivity()).get(CharacterViewModel.class);
    }
    private void setupArgs() {
        id = DetailCharacterFragmentArgs.fromBundle(getArguments()).getPosition();
    }
    private void setupRequest() {
        viewModel.fetchId(id).observe(getViewLifecycleOwner(), characterM -> {
            Glide.with(binding.imageCharacter).load(characterM.getImage()).into(binding.imageCharacter);
            binding.textCharacter.setText(characterM.getName());
            binding.desk.setText(characterM.getStatus());
            binding.text.setText(characterM.getGender());
            binding.log.setText(characterM.getCreated());
        });
    }
}