package bot.discord;

import bot.discord.commands.DiceCommand;
import bot.discord.commands.WhatToPlayCommand;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.jagrosh.jdautilities.examples.command.AboutCommand;
import com.jagrosh.jdautilities.examples.command.PingCommand;
import com.jagrosh.jdautilities.examples.command.ShutdownCommand;
import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException, LoginException, IllegalArgumentException, RateLimitedException{
        // config.txt contains two lines
        List<String> list = Files.readAllLines(Paths.get("src/main/token.txt"));

        // the first is the bot token
        String token = list.get(0);

        // the second is the bot's owner's id
        String ownerId = list.get(1);

        // define an eventwaiter, dont forget to add this to the JDABuilder!
        EventWaiter waiter = new EventWaiter();

        // define a command client
        CommandClientBuilder client = new CommandClientBuilder();

        // The default is "Type !!help" (or whatver prefix you set)
        client.useDefaultGame();

        // sets the owner of the bot
        client.setOwnerId(ownerId);

        // sets emojis used throughout the bot on successes, warnings, and failures
        client.setEmojis("\uD83D\uDE03", "\uD83D\uDE2E", "\uD83D\uDE26");

        // sets the bot prefix
        client.setPrefix("-");
        client.setAlternativePrefix("!");

        // adds commands
        client.addCommands(
                // command to show information about the bot
                new AboutCommand(Color.BLUE, "Things of DnD",
                        new String[]{"Cool commands","Things related to DnD","Lots of fun!"},
                        new Permission[]{Permission.ADMINISTRATOR}),

                // command to find out what to play
                new WhatToPlayCommand(),
                // command to check bot latency
                new PingCommand(),

                // command to roll dice
                new DiceCommand(),

                // command to shut off the bot
                new ShutdownCommand());

        // start getting a bot account set up
        new JDABuilder(AccountType.BOT)
                // set the token
                .setToken(token)

                // set the game for when the bot is loading
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setGame(Game.playing("loading..."))

                // add the listeners
                .addEventListener(waiter)
                .addEventListener(client.build())

                // start it up!
                .buildAsync();
    }
}
