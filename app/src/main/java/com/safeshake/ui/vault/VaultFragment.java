package com.safeshake.ui.vault;

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

import com.safeshake.databinding.FragmentVaultBinding;

public class VaultFragment extends Fragment {

    private VaultViewModel vaultViewModel;
    private FragmentVaultBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vaultViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(VaultViewModel.class);

        binding = FragmentVaultBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textVault;
        vaultViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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