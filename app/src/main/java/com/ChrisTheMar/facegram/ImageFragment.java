package com.ChrisTheMar.facegram;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.ChrisTheMar.facegram.Network.ImageRequester;
import com.android.volley.toolbox.NetworkImageView;

public class ImageFragment extends Fragment {

    NetworkImageView imagenNet;
    String imgUserFound;
    private ImageRequester imageRequester;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imagenNet=view.findViewById(R.id.imageUserPrev);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageRequester=ImageRequester.getInstance();
        getParentFragmentManager().setFragmentResultListener("key", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                imgUserFound=result.getString("img");
                Log.e("img",imgUserFound);
                //Aca se realiza la solucion
                imageRequester.setImageFormUrl(imagenNet,imgUserFound);
            }
        });
    }
}