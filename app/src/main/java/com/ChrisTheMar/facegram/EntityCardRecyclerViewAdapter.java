package com.ChrisTheMar.facegram;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ChrisTheMar.facegram.Network.Entity;
import com.ChrisTheMar.facegram.Network.ImageRequester;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

public class EntityCardRecyclerViewAdapter extends RecyclerView.Adapter<EntityCardViewHolder> {

    public static List<Entity> entityList;
    private ImageRequester imageRequester;

    EntityCardRecyclerViewAdapter(List<Entity> entityList){
        this.entityList=entityList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public EntityCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_init_main,parent,false);
        return new EntityCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull EntityCardViewHolder holder, int position) {
        if(entityList!=null && position<entityList.size()){
            Entity entity=entityList.get(position);
            //NAME-TITLE
            holder.EntityTitleUser.setText(entity.nametitle);
            //SUBAME
            holder.EntitySubName.setText(entity.subname);
            //USER-IMAGE
            imageRequester.setImageFormUrl(holder.EntityImageUser,entity.urlimageuser);
            //IMAGE-CENTER
            imageRequester.setImageFormUrl(holder.EntityImageBig,entity.urlimagebig);
            //HEART
            holder.EntityHeart.setText(entity.heart);
            //COMMENT
            holder.EntityComment.setText(entity.comment);
            //SAVE
            holder.EntitySave.setText(entity.save);

        }
    }

    @Override
    public int getItemCount() {
        return entityList.size();
    }

}

