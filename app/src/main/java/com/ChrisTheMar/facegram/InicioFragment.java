package com.ChrisTheMar.facegram;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class InicioFragment extends Fragment {

    Button btnLogin;
    Button btnGuest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnLogin=view.findViewById(R.id.btnLogin);
        btnGuest=view.findViewById(R.id.btnInvite);
        dirigirToMenu();
        dirigirToMenuGuest();
    }

    private void dirigirToMenu(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Navigation)getActivity()).navigate(new MainFragment(),false);
            }
        });
    }

    private void dirigirToMenuGuest(){
        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Navigation)getActivity()).navigate(new MainFragment(),true);
            }
        });
    }

}