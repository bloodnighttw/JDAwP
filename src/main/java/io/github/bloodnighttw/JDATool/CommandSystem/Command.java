package io.github.bloodnighttw.JDATool.CommandSystem;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;


public abstract class Command  {

    public abstract void hacdle(String[] args, GuildMessageReceivedEvent event) ;

    public abstract String[] getCommandName();

    public abstract String getDescription();

}
