package me.xbones.essentialfeatures.commands;

import me.xbones.essentialfeatures.EssentialFeatures;
import me.xbones.essentialfeatures.chatcomponentapi.ChatComponentAPI;
import me.xbones.essentialfeatures.utils.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// ef Command Executor
public class MSGCommand implements CommandExecutor {

    // VARIABLES //
    private EssentialFeatures main;
    // VARIABLES//

    // CONSTRUCTOR //
    public MSGCommand(EssentialFeatures main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender.hasPermission("ef.msg")) {
            if (args.length < 2) {
                sender.sendMessage(TextUtils.color(main.getPrefix() + " &cPlease enter player name and a message!"));
            } else {
                Player target = Bukkit.getPlayer(args[0]);
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    sb.append(args[i]).append(" ");
                }

                String Message = sb.toString().trim();
                ChatComponentAPI.sendHoverChat(target, TextUtils.color("&a[&7" + sender.getName() + " &9-> &aYou: " + Message), TextUtils.color("&aYou have received a message from " + sender.getName()));
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    ChatComponentAPI.sendHoverChat(p, TextUtils.color("&a[&7You &9-> " + "&a" +     target.getName() + ": " + Message), TextUtils.color("&aYou have sent a message to " + target.getName()));
                } else {
                    sender.sendMessage("You -> " + target.getName() + ": " + Message);
                }

            }
        } else {
            sender.sendMessage(TextUtils.color(main.getPrefix() + " &cYou do not have access to this command."));
        }
        return true;
    }
}
