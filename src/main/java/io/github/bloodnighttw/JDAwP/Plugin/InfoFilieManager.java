package io.github.bloodnighttw.JDAwP.Plugin;


import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InfoFilieManager {

    private static InfoFilieManager instance;
    private InfoFilieManager(){}

    public static InfoFilieManager getInstance(){
        if(instance==null)
            instance=new InfoFilieManager();
        return instance;
    }

    public PluginInfo getInfoFile(String path){
        Gson gson=new Gson();
        PluginInfo infoFile=null;
        try {
            String st="";
            Scanner sc=new Scanner(new URL("jar:file:"+path+"!/info.json").openStream());
            for(int i=0;i<50;i++){
                try {
                    st=st+sc.nextLine()+"\n";
                }catch (NoSuchElementException e){
                    break;
                }
            }
            //System.out.println(st);
            infoFile=gson.fromJson(st,PluginInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return infoFile;
    }

    public void generateIndoFile(String MainClass,String PluginName,String version){
        PluginInfo pi=new PluginInfo(MainClass,PluginName,version,"[]");
        System.out.println(new Gson().toJson(pi));

    }

}
