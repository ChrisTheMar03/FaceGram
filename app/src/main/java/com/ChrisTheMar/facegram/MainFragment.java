package com.ChrisTheMar.facegram;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ChrisTheMar.facegram.Network.Entity;


public class MainFragment extends Fragment {

    ImageButton btnOption,btnSearch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main,container,false);

        RecyclerView recyclerView=view.findViewById(R.id.rv_ig);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false));
        EntityCardRecyclerViewAdapter adapter=new EntityCardRecyclerViewAdapter(
                Entity.initEntityList(getResources()));
        recyclerView.setAdapter(adapter);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnOption=view.findViewById(R.id.btn_options_main);
        btnSearch=view.findViewById(R.id.btn_search_main);


        btnOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertMax();
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertMax();
            }
        });


    }

    public void alertMax(){
        Toast.makeText(getContext(),"Option not valid",Toast.LENGTH_SHORT).show();
    }

}