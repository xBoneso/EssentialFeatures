package me.xbones.essentialfeatures.chatcomponentapi;


import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatComponentAPI {

    public ChatComponentAPI() {}

    public static void sendHoverChat(Player player, String message, String hover)
    {
        TextComponent component = new TextComponent(ChatColor.translateAlternateColorCodes('&', message));
        component.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', hover))
                        .create()));
        player.spigot().sendMessage(component);
    }

    public static void sendClickChat(Player player, String message, String hover, String command) {
        TextComponent component = new TextComponent(ChatColor.translateAlternateColorCodes('&', message));
        component.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', hover))
                        .create()));
        component.setClickEvent(new net.md_5.bungee.api.chat.ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.RUN_COMMAND, command));
        player.spigot().sendMessage(component);
    }

    public static void sendClickOpenURLChat(Player player, String message, String hover, String url) { TextComponent component = new TextComponent(ChatColor.translateAlternateColorCodes('&', message));
        component.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', hover))
                        .create()));
        component.setClickEvent(new net.md_5.bungee.api.chat.ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.OPEN_URL, url));
        player.spigot().sendMessage(component);
    }

    public static void sendSuggestCommand(Player player, String message, String hover, String command) { TextComponent component = new TextComponent(ChatColor.translateAlternateColorCodes('&', message));
        component.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', hover))
                        .create()));
        component.setClickEvent(new net.md_5.bungee.api.chat.ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.SUGGEST_COMMAND, command));
        player.spigot().sendMessage(component);
    }

}
