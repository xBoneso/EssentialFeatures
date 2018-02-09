package me.xbones.essentialfeatures.API;

import me.xbones.essentialfeatures.chatcomponentapi.ChatComponentAPI;
import me.xbones.essentialfeatures.gang.Gang;
import me.xbones.essentialfeatures.player.EPlayer;
import me.xbones.essentialfeatures.utils.TextUtils;
import me.xbones.essentialfeatures.utils.Utils;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

// ESSENTIALFEATURES OFFICIAL API
public class EssentialFeaturesAPI {

    // VARIABLES //
    Utils utils = new Utils();
    // VARIABLES //

    // USE TO COLOR TEXT
    public String color(String message) {
        return TextUtils.color(message);
    }

    public List<Gang> getGangs() {
        return utils.getGangs();
    }

    public void saveGangs(List<Gang> gangs) {
        utils.saveGangsYML();
        utils.saveGangs(gangs);
    }

    public EPlayer getEPlayer(UUID uuid) {
        EPlayer ePlayer = new EPlayer(uuid);
        return ePlayer;
    }

    public EPlayer getEPlayer(String name) {
        return getEPlayer(Bukkit.getPlayer(name).getUniqueId());
    }

    public static void sendHoverChat(Player player, String message, String hover){
        ChatComponentAPI.sendHoverChat(player, message, hover);
    }

    public static void sendClickChat(Player player, String message, String hover, String command) {
        ChatComponentAPI.sendClickChat(player, message, hover, command);
    }

    public static void sendClickOpenURLChat(Player player, String message, String hover, String url) {
        ChatComponentAPI.sendClickOpenURLChat(player, message, hover, url);
    }

    public static void sendSuggestCommand(Player player, String message, String hover, String command) {
        ChatComponentAPI.sendSuggestCommand(player, message, hover, command);
    }
}
