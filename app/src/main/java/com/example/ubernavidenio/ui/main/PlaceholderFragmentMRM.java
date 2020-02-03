package com.example.ubernavidenio.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ubernavidenio.R;
import com.example.ubernavidenio.fragments.RPolo;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragmentMRM extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModelMRM pageViewModelMRM;

    public static Fragment newInstance(int index) {
        Fragment fragment=null;

        switch (index){
            case 1:fragment=new RPolo();break;
            case 2:fragment=new RPolo();break;
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModelMRM = ViewModelProviders.of(this).get(PageViewModelMRM.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModelMRM.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menu_masculino_r, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        pageViewModelMRM.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}