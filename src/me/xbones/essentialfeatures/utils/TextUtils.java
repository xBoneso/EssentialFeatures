package me.xbones.essentialfeatures.utils;

import org.bukkit.ChatColor;

// TEXT UTILS CLASS //
public final class TextUtils {

    // VARIABLES //
    // VARIABLES //

    // COLORS MESSAGES
    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
