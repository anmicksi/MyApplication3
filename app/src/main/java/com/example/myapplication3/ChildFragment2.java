package com.example.myapplication3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication3.databinding.ChildFragment2Binding;

public class ChildFragment2 extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ChildFragment2Binding binding = ChildFragment2Binding.inflate(getLayoutInflater());

        binding.button.setOnClickListener(view -> {
            Bundle result = new Bundle();
            result.putString("bundleKey", "Результат от нижнего фрагмента");
            getParentFragmentManager().setFragmentResult(
                    "requestKey", result);
        });

        return binding.getRoot();
    }
}