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
import com.example.ubernavidenio.fragments.Femenino;
import com.example.ubernavidenio.fragments.MasculinoFragment;
import com.example.ubernavidenio.fragments.UnixeFragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragmentR extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModelR pageViewModelR;

    public static Fragment newInstance(int index) {
        Fragment fragment=null;

        switch (index){
            case 1:fragment=new MasculinoFragment();break;
            case 2:fragment=new Femenino();break;
            case 3:fragment=new UnixeFragment();break;
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModelR = ViewModelProviders.of(this).get(PageViewModelR.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModelR.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menu__ropa, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        pageViewModelR.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }


}