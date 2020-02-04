package io.github.bloodnighttw.JDATool.CommandSystem;

import io.github.bloodnighttw.JDAwP.Error.SecondSettingObjectExpection;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

public class helpHandler extends Command{

    private final String perfix;

    public helpHandler(String perfix) {
        this.perfix = perfix;
    }

    @Override
    public void hacdle(String[] args, GuildMessageReceivedEvent event){
        EmbedBuilder embedBuilder=new EmbedBuilder();
        embedBuilder.setTitle("All Command")
                    .setColor(Color.RED)
                    .setDescription("=======================================\n\n");

        HashMap hashMap= null;
        try {
            hashMap = CommandHandler.getInstance().getHashMap();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Object[] AllKeyList= hashMap.keySet().toArray();

        for(Object st:AllKeyList){

            Command command= (Command) hashMap.get(st);

            embedBuilder.appendDescription(" ```"+command.getDescription()+"```\n\n");

        }
        embedBuilder.appendDescription("=======================================");


        event.getMessage().getChannel().sendMessage(embedBuilder.build()).queue();

    }

    @Override
    public String[] getCommandName() {
        return new String[]{perfix + "help"};
    }

    @Override
    public String getDescription() {
        return "Usage: =help \n"+
                "Description: get Command List.";
    }

}
