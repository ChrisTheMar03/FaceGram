package com.ChrisTheMar.facegram;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.ChrisTheMar.facegram.Network.Entity;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

public class EntityCardViewHolder extends RecyclerView.ViewHolder{

    public NetworkImageView EntityImageUser;
    public TextView EntityTitleUser;
    public TextView EntitySubName;
    public NetworkImageView EntityImageBig;
    public TextView EntityHeart;
    public TextView EntityComment;
    public TextView EntitySave;
    public ImageButton EntityOptions;

    public EntityCardViewHolder(@NonNull View itemView){
        super(itemView);
        EntityImageUser=itemView.findViewById(R.id.img_user_header);
        EntityTitleUser=itemView.findViewById(R.id.txt_user_name_header);
        EntitySubName=itemView.findViewById(R.id.txt_user_root_header);
        EntityImageBig=itemView.findViewById(R.id.img_user_center);
        EntityHeart=itemView.findViewById(R.id.txt_count_heart);
        EntityComment=itemView.findViewById(R.id.txt_count_comments);
        EntitySave=itemView.findViewById(R.id.txt_saves);
        EntityOptions=itemView.findViewById(R.id.btn_options);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context=view.getContext();
                Intent intent=new Intent(context,DetailActivity.class);
                intent.putExtra("nombreId",EntityCardRecyclerViewAdapter.entityList.get(getAdapterPosition()).nametitle);
                intent.putExtra("imgUser",EntityCardRecyclerViewAdapter.entityList.get(getAdapterPosition()).urlimageuser);
                context.startActivity(intent);
            }
        });

        EntityOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Options Not Valid",Toast.LENGTH_SHORT).show();
            }
        });

    }

}
