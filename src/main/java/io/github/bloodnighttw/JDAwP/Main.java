package io.github.bloodnighttw.JDAwP;

import com.google.gson.Gson;
import io.github.bloodnighttw.JDAwP.Plugin.InfoFilieManager;
import io.github.bloodnighttw.JDAwP.Plugin.PluginInfo;
import io.github.bloodnighttw.JDAwP.Plugin.PluginLoader;
import io.github.bloodnighttw.JDAwP.ServerTool.Path;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
        PluginLoader pl= PluginLoader.getInstance();
        Path ph=Path.getInstance();

        System.out.println(ph.getPluginFolderPath());
        InfoFilieManager ifm=InfoFilieManager.getInstance();

        Gson gson=new Gson();


        for(String st:ph.getAllJarPathList()) {
            System.out.println(st);
            System.out.println(ifm.getInfoFile(st).getLoadAfter());
        }


    }

}
