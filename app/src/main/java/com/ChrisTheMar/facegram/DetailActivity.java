package com.ChrisTheMar.facegram;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ChrisTheMar.facegram.Network.ImageRequester;
import com.android.volley.toolbox.NetworkImageView;

public class DetailActivity extends AppCompatActivity {

    String nombre="",imgUserUrl="";
    TextView txtnombre;
    NetworkImageView imgUser;
    ImageButton btnBack,btnCampana;
    private ImageRequester imageRequester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.containerDetail, new DetalleFragment())
                    .commit();
        }
    }
}