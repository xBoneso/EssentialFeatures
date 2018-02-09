package me.xbones.essentialfeatures.commands;

import com.sun.deploy.uitoolkit.impl.text.TextUIToolkit;
import me.xbones.essentialfeatures.EssentialFeatures;
import me.xbones.essentialfeatures.chatcomponentapi.ChatComponentAPI;
import me.xbones.essentialfeatures.utils.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// ef Command Executor
public class InfoCommand implements CommandExecutor {

    // VARIABLES //
    private EssentialFeatures main;
    // VARIABLES//

    // CONSTRUCTOR //
    public InfoCommand(EssentialFeatures main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender.hasPermission("ef.info")) {
            if (args.length == 0) {
                if(sender instanceof Player) {
                    Player p = (Player) sender;
                    ChatComponentAPI.sendHoverChat(p, TextUtils.color(main.getPrefix() +" &aInformation:"), TextUtils.color("&aYour information"));
                    ChatComponentAPI.sendHoverChat(p, TextUtils.color(main.getPrefix() +" &aName: " + p.getName()), TextUtils.color("&a" + p.getName()));
                    ChatComponentAPI.sendHoverChat(p, TextUtils.color(main.getPrefix() +" &aUUID: " + p.getUniqueId()), TextUtils.color("&a" + p.getUniqueId()));
                    ChatComponentAPI.sendHoverChat(p, TextUtils.color(main.getPrefix() +" &aDisplay name: " + p.getDisplayName()), TextUtils.color("&a" + p.getDisplayName()));
                    ChatComponentAPI.sendHoverChat(p, TextUtils.color(main.getPrefix() +" &aHealth: " + p.getHealth()), TextUtils.color("&a" + p.getHealth()));
                } else {
                    sender.sendMessage("You are not a player, so please enter player name!");
                }
            } else {
                Player target = Bukkit.getPlayer(args[0]);
                if(target != null) {
                    if (sender instanceof Player) {
                        Player p = (Player) sender;
                        ChatComponentAPI.sendHoverChat(p, TextUtils.color(main.getPrefix() + " &aInformation:"), TextUtils.color("&aInformation about " + target.getName()));
                        ChatComponentAPI.sendHoverChat(p, TextUtils.color(main.getPrefix() + " &aName: " + target.getName()), TextUtils.color("&a" + target.getName()));
                        ChatComponentAPI.sendHoverChat(p, TextUtils.color(main.getPrefix() + " &aUUID: " + target.getUniqueId()), TextUtils.color("&a" + target.getUniqueId()));
                        ChatComponentAPI.sendHoverChat(p, TextUtils.color(main.getPrefix() + " &aDisplay name: " + target.getDisplayName()), TextUtils.color("&a" + target.getDisplayName()));
                        ChatComponentAPI.sendHoverChat(p, TextUtils.color(main.getPrefix() + " &aHealth: " + target.getHealth()), TextUtils.color("&a" + target.getHealth()));
                    } else {
                        sender.sendMessage("Information:");
                        sender.sendMessage("Name: " + target.getName());
                        sender.sendMessage("UUID: " + target.getUniqueId());
                        sender.sendMessage("Display name: " + target.getDisplayName());
                        sender.sendMessage("Health: " + target.getHealth());
                    }
                } else {
                    sender.sendMessage(TextUtils.color(main.getPrefix() + " &cPlayer not online!"));
                }
            }
        } else {
            sender.sendMessage(TextUtils.color(main.getPrefix() + " &cYou do not have access to this command."));
        }
        return true;
    }
}
