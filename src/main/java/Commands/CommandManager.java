package Commands;

import Commands.CmdJoke;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class CommandManager extends ListenerAdapter {
    //Two type of commands:
    //Guild commands: instantly updated. Only affects to a single guild. Max 100 commands
    //Global commands: up to 1h to update. Affects to all guilds that your bot is in. Unlimited Commands.
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String command = event.getName();
        if (command.equals("welcome")) {
            String userTag = event.getUser().getAsTag();
            event.reply("Welcome Inter! @" + userTag).queue();

        } else if (command.equals("joke")) {
            String joke = CmdJoke.getJoke();
            event.reply(joke).queue();
        } else if (command.equals("aramourf")) {
            EmbedBuilder eb = new EmbedBuilder();
            eb = Cmdurfoaram.getMode();
            event.replyEmbeds(eb.build()).queue();
        } else if (command.equals("randomchamp")) {
            String randomchamp;
            randomchamp = CmdRandomChamp.getChamp();
            event.reply(randomchamp).queue();
        } else if (command.equals("say")) {
            //We need to grab the message (2nd arg) of the /say command . (/say <message)
            //event.getOption("message"); -->We saving message into a OptionMapping variable
            OptionMapping messageOption = event.getOption("message");
            if (messageOption != null) {
                String message = messageOption.getAsString();
                event.getChannel().sendMessage(message).queue();
            } else {
                event.getChannel().sendMessage("Error");
            }
            //Command clear is separated
        }
    }


    @Override
    public void onGuildReady(GuildReadyEvent event) {
        //Creating a List to add all commands
        List<CommandData> commandData = new ArrayList<>();
        //Registering welcome command in our commandData List
        commandData.add(Commands.slash("welcome", "Get a welcome from the bot"));
        //Adding more commands to our commandData List:
        commandData.add(Commands.slash("joke", "Some gapo facts"));
        commandData.add(Commands.slash("aramourf", "Choose between urf or aram"));
        commandData.add(Commands.slash("randomchamp", "Picks a random champ for you"));
        //Creating /say <message> command. It has 2 args so we need to add Options to our command.
        OptionData option1 = new OptionData(OptionType.STRING, "message", "The message u want the bot to say", true);
        commandData.add(Commands.slash("say", "Say something through the bot").addOptions(option1));
        //Creating Option for clear command
        OptionData option2 = new OptionData(OptionType.INTEGER, "amount", "Amount of messages u want to delete", true);
        //Addind the command to the list, so it gets updated to our commandList
        commandData.add(Commands.slash("clear", "Delete an amount of messages").addOptions(option2));
        //Registering the commaxnd in an specific guild
        event.getGuild().updateCommands().addCommands(commandData).queue();

    }

}