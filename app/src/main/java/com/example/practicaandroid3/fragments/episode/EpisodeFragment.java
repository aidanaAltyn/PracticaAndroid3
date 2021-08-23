package com.example.practicaandroid3.fragments.episode;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practicaandroid3.R;
import com.example.practicaandroid3.databinding.FragmentEpisodeBinding;


public class EpisodeFragment extends Fragment {
    FragmentEpisodeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEpisodeBinding.inflate(inflater, container, false);
        return  binding.getRoot();
    }
}