package com.safeshake.ui.generator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;

import com.safeshake.databinding.FragmentGeneratorBinding;

public class GeneratorFragment extends Fragment {

    private GeneratorViewModel generatorViewModel;
    private FragmentGeneratorBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        generatorViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(GeneratorViewModel.class);

        binding = FragmentGeneratorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGenerator;
        generatorViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}