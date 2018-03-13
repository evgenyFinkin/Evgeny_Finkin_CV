package com.example.jonfi.evgenyfinkincv.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jonfi.evgenyfinkincv.R;

/**
 * Created by jonfi on 06/03/2018.
 */

public class Bio extends Fragment {
    private static final String TAG = "Bio";
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bio, container, false);
        return view;
    }
}
