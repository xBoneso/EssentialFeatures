package me.xbones.essentialfeatures.commands;

import me.xbones.essentialfeatures.EssentialFeatures;
import me.xbones.essentialfeatures.utils.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// Gamemode Command Executor
public class HealCommand implements CommandExecutor {

    // VARIABLES //
    private EssentialFeatures main;
    // VARIABLES//

    // CONSTRUCTOR //
    public HealCommand(EssentialFeatures main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0) {
                Player p = (Player) sender;
                p.setHealth(p.getMaxHealth());
                p.sendMessage(TextUtils.color(main.getPrefix() + " &aYou have healed yourself!"));
            } else {
                Player target = Bukkit.getPlayer(args[0]);
                Player p = (Player) sender;
                if(target != null) {
                    target.setHealth(target.getMaxHealth());
                    p.sendMessage(TextUtils.color(main.getPrefix() + " &aYou have healed " + target.getName() + "!"));
                } else {
                    p.sendMessage(TextUtils.color(main.getPrefix() + "&cPlayer is not online!"));
                }
            }
        } else {
            sender.sendMessage("Can only be used in game.");
        }
        return true;
    }
}
