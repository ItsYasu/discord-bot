package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class CmdClear extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        List<OptionMapping> options = event.getOptions();
        int amount = options.get(0).getAsInt();

        if (event.getName().equals("clear")) {
            if (amount < 1) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(0xff3923);
                usage.setTitle("Specify amount to delete");
                usage.setDescription("Usage: /clear [# of messages]");
                event.getChannel().sendMessageEmbeds(usage.build()).queue();
            } else {
                List<Message> messages = event.getChannel().getHistory().retrievePast(amount).complete();
                event.getChannel().purgeMessages(messages);
                event.getChannel().sendMessage("Messages has been deleted!").queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
            }
        }
    }
}