package io.github.bloodnighttw.JDAwP;

import com.google.gson.Gson;
import io.github.bloodnighttw.JDAwP.Error.SecondSettingObjectExpection;
import io.github.bloodnighttw.JDAwP.Plugin.PluginLoader;
import io.github.bloodnighttw.JDAwP.ServerTool.JDAGetter;
import io.github.bloodnighttw.JDAwP.ServerTool.Path;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.io.*;
import java.net.URISyntaxException;

public class Main {

    private static final Logger log=LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws URISyntaxException, IOException, ClassNotFoundException, LoginException, SecondSettingObjectExpection {
        Gson gson=new Gson();
        Path ph=Path.getInstance();

        PluginLoader pl= PluginLoader.getInstance();
        JDAGetter jdaGetter=JDAGetter.getInstance();
        JDA jda=jdaGetter.getJda();
        for(String st:ph.getAllJarPathList()) {
            log.info("find a jar package which can load:"+st);
            pl.startLoading(st);
        }
    }

}

