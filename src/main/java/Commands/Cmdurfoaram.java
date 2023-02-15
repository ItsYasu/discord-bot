package Commands;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.Random;

public class Cmdurfoaram {
    public static EmbedBuilder getMode(){
        Random random = new Random();
        int randomnumber;
        randomnumber = random.nextInt(2)+1;
        if (randomnumber == 1) {
            //Embed message
            EmbedBuilder eb1 = new EmbedBuilder();
            eb1.setColor(Color.cyan);
            eb1.setTitle("✔ URF");
            eb1.setDescription("The selected mode is: URF");
            return eb1;
        } else if (randomnumber == 2) {
            //Embed messages
            EmbedBuilder eb2 = new EmbedBuilder();
            eb2.setColor(Color.cyan);
            eb2.setTitle("✔ ARAM");
            eb2.setDescription("The selected mode is: Aram");
            return eb2;
            //Sending message
            // event.reply("aram").queue();
        } else {
            EmbedBuilder eb3 = new EmbedBuilder();
            eb3.setColor(Color.red);
            eb3.setTitle("✔ Error");
            eb3.setDescription("Error");
            return eb3;


        }

    }
}
