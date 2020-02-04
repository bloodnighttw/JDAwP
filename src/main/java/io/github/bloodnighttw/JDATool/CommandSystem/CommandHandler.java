package io.github.bloodnighttw.JDATool.CommandSystem;

import io.github.bloodnighttw.JDAwP.Error.SecondSettingObjectExpection;
import io.github.bloodnighttw.JDAwP.ServerTool.JDAGetter;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

public class CommandHandler extends ListenerAdapter {

    private static CommandHandler instance;
    private final HashMap<String,Command> hashMap=new HashMap();
    
    private CommandHandler(){    }

    public static CommandHandler getInstance() throws LoginException, URISyntaxException, SecondSettingObjectExpection, IOException {
        if(instance==null) {
            instance = new CommandHandler();
            JDAGetter jdag=JDAGetter.getInstance();
            jdag.getJda().addEventListener(instance);
        }

        instance.addCommand(new helpHandler("="));

        return instance;
    }

    public void addCommand(Command command){
        for(String st:command.getCommandName())
            hashMap.put(st,command);
    }

    HashMap<String,Command> getHashMap(){
        return hashMap;
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] messange=event.getMessage().getContentRaw().split(" ");
        Command command=hashMap.get(messange[0]);

        if(command==null)
            return;

        String[] args=new String[messange.length-1];
        System.arraycopy(messange,1,args,0,messange.length-1);
        command.hacdle(args,event);

    }
}
