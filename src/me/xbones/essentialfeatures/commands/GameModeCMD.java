package me.xbones.essentialfeatures.commands;

import me.xbones.essentialfeatures.EssentialFeatures;
import me.xbones.essentialfeatures.chatcomponentapi.ChatComponentAPI;
import me.xbones.essentialfeatures.utils.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// Gamemode Command Executor
public class GameModeCMD implements CommandExecutor {

    // VARIABLES //
    private EssentialFeatures main;
    // VARIABLES//

    // CONSTRUCTOR //
    public GameModeCMD(EssentialFeatures main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if(args.length == 0) {
                if (cmd.getName().equalsIgnoreCase("gmc")) {
                    if(sender.hasPermission("ef.gamemode.creative")) {
                        Player p = (Player) sender;
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(TextUtils.color(main.getPrefix() + " &aYou have set your gamemode to Creative."));
                    } else
                    {
                        sender.sendMessage(TextUtils.color(main.getPrefix() + " &cYou do not have access to this command."));
                    }
                } else if (cmd.getName().equalsIgnoreCase("gms")) {
                    if(sender.hasPermission("ef.gamemode.survival")) {
                        Player p = (Player) sender;
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(TextUtils.color(main.getPrefix() + " &aYou have set your gamemode to Survival."));
                    } else
                        sender.sendMessage(TextUtils.color(main.getPrefix() + " &cYou do not have access to this command."));
                } else if (cmd.getName().equalsIgnoreCase("gmsp")) {
                    if(sender.hasPermission("ef.gamemode.spectator")) {
                        Player p = (Player) sender;
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(TextUtils.color(main.getPrefix() + " &aYou have set your gamemode to Spectator."));
                    } else {
                        sender.sendMessage(TextUtils.color(main.getPrefix() + " &cYou do not have access to this command."));
                    }
                } else if (cmd.getName().equalsIgnoreCase("gma")) {
                    if(sender.hasPermission("ef.gamemode.gma")) {
                        Player p = (Player) sender;
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(TextUtils.color(main.getPrefix() + " &aYou have set your gamemode to Adventure."));
                    } else {
                        sender.sendMessage(TextUtils.color(main.getPrefix() + " &cYou do not have access to this command."));
                    }
                }
            } else {
                Player p = (Player) sender;
                Player target = Bukkit.getPlayer(args[0]);
                if(target != null){
                    if (cmd.getName().equalsIgnoreCase("gmc")) {
                        if(sender.hasPermission("ef.gamemode.gmc")) {
                            target.setGameMode(GameMode.CREATIVE);
                            p.sendMessage(TextUtils.color(main.getPrefix() + " &aYou have set " + target.getName() + "'s gamemode to Creative."));
                        } else
                            sender.sendMessage(TextUtils.color(main.getPrefix() + " &cYou do not have access to this command."));
                    } else if (cmd.getName().equalsIgnoreCase("gms")) {
                        if(sender.hasPermission("ef.gamemode.gms")) {
                            target.setGameMode(GameMode.SURVIVAL);
                            p.sendMessage(TextUtils.color(main.getPrefix() + " &aYou have set " + target.getName() + "'s gamemode to Survival."));
                        } else {
                            sender.sendMessage(TextUtils.color(main.getPrefix() + " &cYou do not have access to this command."));
                        }
                    } else if (cmd.getName().equalsIgnoreCase("gmsp")) {
                        if(sender.hasPermission("ef.gamemode.gmsp")) {
                            target.setGameMode(GameMode.SPECTATOR);
                            p.sendMessage(TextUtils.color(main.getPrefix() + " &aYou have set " + target.getName() + "'s gamemode to Spectator."));
                        } else {
                            sender.sendMessage(TextUtils.color(main.getPrefix() + " &cYou do not have access to this command."));
                        }
                    } else if (cmd.getName().equalsIgnoreCase("gma")) {
                        if(sender.hasPermission("ef.gamemode.gma")) {
                            target.setGameMode(GameMode.ADVENTURE);
                            p.sendMessage(TextUtils.color(main.getPrefix() + " &aYou have set " + target.getName() + "'s gamemode to Adventure."));
                        } else
                            sender.sendMessage(TextUtils.color(main.getPrefix() + " &cYou do not have access to this command."));
                    }

                } else {
                    p.sendMessage(TextUtils.color(main.getPrefix() + " &cPlayer is not online!"));
                }
            }
            } else {
            sender.sendMessage("Can only be used in game.");
        }
        return true;
    }
}
