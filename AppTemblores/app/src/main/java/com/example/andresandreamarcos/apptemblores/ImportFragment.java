package com.example.andresandreamarcos.apptemblores;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by andrea on 11/3/16.
 */
public class ImportFragment extends Fragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            return inflater.inflate(R.layout.fragment_gmaps,container,false);
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState){
       super.onViewCreated(view, savedInstanceState);
        }
    }

