package bot.discord.commands;

import bot.discord.DnDCharacterRandomizer;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class WhatToPlayCommand extends Command {

    public WhatToPlayCommand(){
        this.name = "whattoplay";
        this.help = "randomly creates a DnD character to play";
        this.guildOnly = false;
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        commandEvent.replySuccess(commandEvent.getAuthor().getName()+ ", Droop think you "+ DnDCharacterRandomizer.characterRandomized());
    }
}
