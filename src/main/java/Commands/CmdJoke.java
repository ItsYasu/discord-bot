package Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.Random;

public class CmdJoke extends ListenerAdapter {
    private static final String[] JOKES = {
            "Alxx can carry your botlane!",
            "Is better to be far away from botlane Bambax08!",
            "Thanks to god u main champs such as yasuo, katarian... Diegordo01",
            "Thanks to god Cogollo isn't even playing League otherwise... makakos wouldn't win a single game",
            "Yasu is a coinflip. Just play with him if u like gambling",
            "Hi I'm Degrec and I use cr4cked scripts",
            "Guess who I am. I love playing Top because I love being autism and ignored by my team!",
            "Ferxxo User is god as Sylas!",
            "Does motorbikes works when they get wet?",
            "You are the joke bro!",
            "There're no jokes for you",
            "Degrec inting with ezreal",
            "Bambax it's just farming",
            "Lubina inting 1vs5"
    };
    public static String getJoke() {
        //Calling the RandomGen Class. It randomize a number from 0 to 11
        String joke;
        //We save the random number into opcion variable
       Random random = new Random();
       int index;
       index = random.nextInt(JOKES.length)+1;
        return JOKES[index];
    }
}
