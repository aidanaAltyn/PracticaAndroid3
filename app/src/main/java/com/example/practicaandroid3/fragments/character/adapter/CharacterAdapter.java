package com.example.practicaandroid3.fragments.character.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.practicaandroid3.OnItemClickListener;
import com.example.practicaandroid3.databinding.ItemCharecterBinding;
import com.example.practicaandroid3.models.CharacterM;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {
    private ItemCharecterBinding binding;
    private OnItemClickListener onItemClickListener;
    private ArrayList<CharacterM> list = new ArrayList<>();

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void addData(ArrayList<CharacterM> list1) {
        this.list = list1;
        notifyDataSetChanged();
    }
    @Override
    public CharacterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemCharecterBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterAdapter.ViewHolder holder, int position) {
        holder.bind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) { super(itemView);
        }

        public void bind(CharacterM characterM) {
            Glide.with(binding.image).load(characterM.getImage()).into(binding.image);
            binding.titleCharacter.setText(characterM.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClickItem(getAdapterPosition());
                }
            });
        }
    }
}
