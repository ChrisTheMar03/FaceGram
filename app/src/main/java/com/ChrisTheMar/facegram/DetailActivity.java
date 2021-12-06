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
        imageRequester=ImageRequester.getInstance();
        btnBack=findViewById(R.id.btn_back_detail);
        btnCampana=findViewById(R.id.btn_campana_detail);
        txtnombre=findViewById(R.id.txt_root_detail);
        imgUser=findViewById(R.id.img_user_detail);



        if(savedInstanceState==null){
            Bundle extras=getIntent().getExtras();
            if(extras==null){
                nombre=null;
            }else{
                nombre=extras.getString("nombreId");
                imgUserUrl=extras.getString("imgUser");
                txtnombre.setText("@"+nombre);
                //Log.e("URLImagen",imgUserUrl);
                //imgUser.setImageURI();
                imageRequester.setImageFormUrl(imgUser,imgUserUrl);
            }
        }else{
            //validar diferentes formas de commo podemos recibir el parametro que nos estan enviando
            nombre=(String)savedInstanceState.getSerializable("nombreId");
        }


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnCampana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertC();
            }
        });

        txtnombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"User: "+txtnombre.getText(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void alertC(){
        Dialog alertDialog=new AlertDialog.Builder(this)
                .setTitle("Campana")
                .setMessage("Recibiras una notificacion")
                .setPositiveButton("Aceptar",null)
                .create();
        alertDialog.show();
    }

    public void viewTag(){

    }

}