package com.example.ubernavidenio.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ubernavidenio.R;
import com.example.ubernavidenio.fragments.CelularesFragment;
import com.example.ubernavidenio.fragments.ComputadorasFragment;
import com.example.ubernavidenio.fragments.Impresora;
import com.example.ubernavidenio.fragments.TelevisoresFragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragmentT extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModelT pageViewModelT;

    public static Fragment newInstance(int index) {
        Fragment fragment=null;

        switch (index){
            case 1:fragment=new TelevisoresFragment();break;
            case 2:fragment=new ComputadorasFragment();break;
            case 3:fragment=new Impresora();break;
            case 4:fragment=new CelularesFragment();break;
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModelT = ViewModelProviders.of(this).get(PageViewModelT.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModelT.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_menu__tegnologia, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        pageViewModelT.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}