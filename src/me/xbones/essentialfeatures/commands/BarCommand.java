package me.xbones.essentialfeatures.commands;

import me.xbones.essentialfeatures.EssentialFeatures;
import me.xbones.essentialfeatures.inventories.BarInventory;
import me.xbones.essentialfeatures.utils.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

// Bar Command Executor
public class BarCommand implements CommandExecutor {

    // VARIABLES //
    private EssentialFeatures main;
    // VARIABLES//

    // CONSTRUCTOR //
    public BarCommand(EssentialFeatures main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender.hasPermission("ef.bar")) {
            if (sender instanceof Player) {
                BarInventory inventory = new BarInventory(main);
                inventory.InitializeGUI();
                if(sender instanceof Player){
                    Player p = (Player) sender;
                    p.openInventory(inventory.getBar());
                } else{
                    sender.sendMessage("Can only be used in game!");
                }

            } else {
                sender.sendMessage("Can only be used in game.");
            }
        }else {
            sender.sendMessage(TextUtils.color(main.getPrefix() + " &cYou do not have access to this command."));
        }
        return true;
    }
}
