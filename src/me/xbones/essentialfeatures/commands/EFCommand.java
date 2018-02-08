package me.xbones.essentialfeatures.commands;

import me.xbones.essentialfeatures.EssentialFeatures;
import me.xbones.essentialfeatures.chatcomponentapi.ChatComponentAPI;
import me.xbones.essentialfeatures.utils.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.xml.soap.Text;
import java.awt.*;

// ef Command Executor
public class EFCommand implements CommandExecutor {

    // VARIABLES //
    private EssentialFeatures main;
    // VARIABLES//

    // CONSTRUCTOR //
    public EFCommand(EssentialFeatures main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length ==0) {
            sender.sendMessage(TextUtils.color("&7(&c!&7) &7Essential&cFeatures&6 by xBones &7(&c!&7)"));
            sender.sendMessage(TextUtils.color("&7(&c!&7) &7Commands: (Hover for info) &7(&c!&7)"));
            if (sender instanceof Player) {
                Player player = (Player) sender;
                ChatComponentAPI.sendClickChat(player, TextUtils.color("&7(&c!&7) &7/ef server &7(&c!&7)"), TextUtils.color("&cShowns information about the server!"), "/ef server");
                ChatComponentAPI.sendClickChat(player, TextUtils.color("&7(&c!&7) &7/ef help &7(&c!&7)"), TextUtils.color("&cShows the help page!"), "/ef help");
            } else {
                sender.sendMessage("Commands only viewable in game.");
            }
        } else {
            if(args[0].equalsIgnoreCase("server")){
                sender.sendMessage(TextUtils.color(main.getPrefix() + " &aServer Info:"));
                sender.sendMessage(TextUtils.color(main.getPrefix() + " &aServer Name: " + Bukkit.getServerName()));
                sender.sendMessage(TextUtils.color(main.getPrefix() + " &aServer Version: " + Bukkit.getServer().getVersion()));
                sender.sendMessage(TextUtils.color(main.getPrefix() + " &aServer Max Players: " + main.getConfig().getInt("Max Players")));
                sender.sendMessage(TextUtils.color(main.getPrefix() + " &aServer Online Players: " + Bukkit.getServer().getOnlinePlayers().size()));
            } else if(args[0].equalsIgnoreCase("help")) {
                sender.sendMessage(TextUtils.color("&7(&c!&7) &7Essential&cFeatures&6 by xBones &7(&c!&7)"));
                sender.sendMessage(TextUtils.color("&7(&c!&7) &7Commands: (Hover for info) &7(&c!&7)"));
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    ChatComponentAPI.sendClickChat(player, TextUtils.color("&7(&c!&7) &7/ef server &7(&c!&7)"), TextUtils.color("&cShowns information about the server!"), "/ef server");
                    ChatComponentAPI.sendClickChat(player, TextUtils.color("&7(&c!&7) &7/ef help &7(&c!&7)"), TextUtils.color("&cShows the help page!"), "/ef help");
                } else {
                    sender.sendMessage("Commands only viewable in game.");
                }

            }
        }
        return true;
    }
}
