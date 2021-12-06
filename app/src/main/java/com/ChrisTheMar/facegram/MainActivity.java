package com.ChrisTheMar.facegram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Navigation{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_FaceGram);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container,new InicioFragment())
                    .commit();
        }

    }


    @Override
    public void navigate(Fragment fragment, boolean addTobackStack) {
        FragmentTransaction transaccion=getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.anim.slide_in_left,R.anim.slide_out_left,R.anim.slide_in_right,R.anim.slide_out_right
                )
                .replace(R.id.container,fragment);

        if(addTobackStack){
            transaccion.addToBackStack(null);
        }
        transaccion.commit();
    }
}