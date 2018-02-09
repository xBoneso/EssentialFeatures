package me.xbones.essentialfeatures.commands;

import me.xbones.essentialfeatures.EssentialFeatures;
import me.xbones.essentialfeatures.chatcomponentapi.ChatComponentAPI;
import me.xbones.essentialfeatures.utils.TextUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// ef Command Executor
public class GangCommand implements CommandExecutor {

    // VARIABLES //
    private EssentialFeatures main;
    // VARIABLES//

    // CONSTRUCTOR //
    public GangCommand(EssentialFeatures main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender.hasPermission("ef.gangs")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7(&c!&7) &7Essential&cFeatures&6 by xBones &7(&c!&7)"));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7(&c!&7) &7Commands: (Hover for info) &7(&c!&7)"));
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    ChatComponentAPI.sendClickChat(player, ChatColor.translateAlternateColorCodes('&', "&7(&c!&7) &7/ef something &7(&c!&7)"), net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', "&cShuts down the server!"), "/ef stop");
                    ChatComponentAPI.sendClickChat(player, ChatColor.translateAlternateColorCodes('&', "&7(&c!&7) &7/ef help &7(&c!&7)"), net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', "&cShows the help page!"), "/ef help");
                } else {
                    sender.sendMessage("Commands only viewable in game.");
                }
            } else {
                if (args[0].equalsIgnoreCase("create")) {

                }
            }
        } else {
            sender.sendMessage(TextUtils.color(main.getPrefix() + " &cYou do not have access to this command."));
        }
        return true;
    }
}
