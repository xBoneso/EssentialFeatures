package me.xbones.essentialfeatures.utils;

import com.pzg.www.discord.object.Bot;
import me.xbones.essentialfeatures.EssentialFeatures;
import net.dv8tion.jda.core.entities.TextChannel;

// DISCORD UTILITIES CLASS
public class DiscordUtils {

    // VARIABLES //
    private String token;
    private Bot bot;
    private String cmdPrefix;
    private EssentialFeatures main;
    // VARIABLES //

    // CONSTRUCTOR
    public DiscordUtils(EssentialFeatures main) { this.main = main; }

    public void setupDiscordBot() {
        token = main.getConfig().getString("Discord.Bot Token");
        cmdPrefix = main.getConfig().getString("Discord.Command Prefix");
        bot = new Bot(token, cmdPrefix);
    }

    public void sendMessageToChannel(TextChannel channel, String message) {
        channel.sendMessage(message).complete();
    }

    public TextChannel getTextChannelByID(long id) {
        return bot.getBot().getTextChannelById(id);
    }

    public TextChannel getTextChannelByID(String id) {
        return bot.getBot().getTextChannelById(id);
    }
}
