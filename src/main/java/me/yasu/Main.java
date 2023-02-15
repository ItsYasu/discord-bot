package me.yasu;

import Commands.CmdRandomChamp;
import Commands.CommandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import Commands.CmdClear;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) throws InterruptedException {
        try {
            // Creating the bot (default config)x
            JDA bot = JDABuilder.createDefault(Config.getDiscordApiToken())
                    .setActivity(Activity.playing("with your mom"))
                    .setStatus(OnlineStatus.ONLINE)
                    .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_WEBHOOKS,GatewayIntent.MESSAGE_CONTENT)
                    .addEventListeners(new CommandManager())
                    .addEventListeners(new CmdClear())
                    .build().awaitReady(); // await.Ready() is really important for guild commands

            // Type of commands: Global commands and Guild Commands
            // Global commands: they can be used anywhere: any guild that ur bot in and also
            // in DM's
            // Guild commands: They can only be used in a specific guild

        /*Testing CmdJoke on console
        CmdJoke joke = new CmdJoke();
        String random_joke = CmdJoke.getJoke();
        System.out.println(random_joke);
        */

        } catch (Exception e) {
            System.out.println("Wrong discord token");
        }

    }
}
