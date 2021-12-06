package com.ChrisTheMar.facegram.Network;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.ChrisTheMar.facegram.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Entity {

    private static final String TAG=Entity.class.getCanonicalName();
    public final String nametitle;
    public final String subname;
    public final Uri dynamicUrl;
    public final String urlimageuser;
    public final String urlimagebig;
    public final String heart;
    public final String comment;
    public final String save;

    public Entity(String nametitle,String subname,String dynamicUrl,String urlimageuser,String urlimagebig,String heart,String comment,String save){
        this.nametitle =nametitle;
        this.subname =subname;
        this.dynamicUrl=Uri.parse(dynamicUrl);
        this.urlimageuser =urlimageuser;
        this.urlimagebig=urlimagebig;
        this.heart=heart;
        this.comment=comment;
        this.save=save;
    }

public static List<Entity> initEntityList(Resources resources){
    InputStream inputStream=resources.openRawResource(R.raw.entity);
    Writer writer=new StringWriter();
    char[] buffer=new char[1024];

    try {
        Reader reader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        int pointer;
        while ((pointer=reader.read(buffer))!=-1){
            writer.write(buffer,0,pointer);
        }
    }catch (IOException IOX){
        Log.e(TAG,"Error al escribir o leer el archivo JSON",IOX);
    }finally {
        try {
            inputStream.close();
        }catch (IOException IO){
            Log.e(TAG,"Error al cerra la conexion con el archivo",IO);
        }
    }

    String jsonEntityString=writer.toString();
    Gson gson=new Gson();
    Type EntityListType=new TypeToken<ArrayList<Entity>>(){
    }.getType();

    return gson.fromJson(jsonEntityString,EntityListType);
}

}
