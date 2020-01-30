package io.github.bloodnighttw.JDAwP.ServerTool;


import com.google.gson.Gson;
import io.github.bloodnighttw.JDAwP.Error.SecondSettingObjectExpection;
import io.github.bloodnighttw.JDAwP.Setting;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;
import java.io.*;
import java.net.URISyntaxException;

public class JDAGetter {

    public static JDAGetter instance;

    private final JDA jda;

    public JDAGetter(JDA jda) {
        this.jda = jda;
    }

    public static JDAGetter getInstance() throws SecondSettingObjectExpection, IOException, LoginException, URISyntaxException {
        if(instance==null) {

            Path ph=Path.getInstance();
            Gson gson=new Gson();
            Setting setting = null;
            try {
                BufferedReader bufferedReader=new BufferedReader(new FileReader(ph.getPath()+"/settings.json"));
                setting=gson.fromJson(bufferedReader,Setting.class);
            } catch (FileNotFoundException e) {
                FileWriter writer = new FileWriter(ph.getPath()+"/settings.json");
                writer.write(gson.toJson(new Setting()));
                writer.close();
                System.exit(0);
            }

            JDA jda=new JDABuilder(setting.getToken()).build();

            instance = new JDAGetter(jda);
        }
        return instance;
    }

    public JDA getJda() {
        return jda;
    }
}
