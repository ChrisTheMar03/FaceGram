package com.ChrisTheMar.facegram;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ChrisTheMar.facegram.Network.ImageRequester;
import com.android.volley.toolbox.NetworkImageView;

public class DetalleFragment extends Fragment {

    String nombre="",imgUserUrl="";
    TextView txtnombre;
    NetworkImageView imgUser;
    ImageButton btnBack,btnCampana;
    private ImageRequester imageRequester;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnBack=view.findViewById(R.id.btn_back_detail);
        btnCampana=view.findViewById(R.id.btn_campana_detail);
        txtnombre=view.findViewById(R.id.txt_root_detail);
        imgUser=view.findViewById(R.id.img_user_detail);
        txtnombre.setText(nombre);
        imageRequester.setImageFormUrl(imgUser,imgUserUrl);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
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
                Toast.makeText(getContext(),"User: "+txtnombre.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        //Reemplazando el fragmento
        imgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Obtiniendo la imagen
                Bundle bundle=new Bundle();
                bundle.putString("img",imgUserUrl);
                getParentFragmentManager().setFragmentResult("key",bundle);
                //Redireccionando
                FragmentTransaction frag=getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.containerDetail,new ImageFragment())
                        .addToBackStack("imgUser");
                frag.commit();
            }
        });

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageRequester=ImageRequester.getInstance();
        if(savedInstanceState==null){
            Bundle extras=getActivity().getIntent().getExtras();
            if(extras==null){
                nombre=null;
            }else{
                nombre=extras.getString("nombreId");
                imgUserUrl=extras.getString("imgUser");
                //Log.e("NM",nombre);
                //txtnombre.setText("@"+nombre);
                //Log.e("URLImagen",imgUserUrl);
                //imgUser.setImageURI();
                //imageRequester.setImageFormUrl(imgUser,imgUserUrl);
            }
        }else{
            //validar diferentes formas de commo podemos recibir el parametro que nos estan enviando
            nombre=(String)savedInstanceState.getSerializable("nombreId");
        }
    }

    private void alertC(){
        Dialog alertDialog=new AlertDialog.Builder(getContext())
                .setTitle("Campana")
                .setMessage("Recibiras una notificacion")
                .setPositiveButton("Aceptar",null)
                .create();
        alertDialog.show();

    }

}