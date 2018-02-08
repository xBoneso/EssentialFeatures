package me.xbones.essentialfeatures.utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerUtils {

    // VARIABLES //
    public static FileConfiguration playerData;
    // VARIABLES //

    // Creates the .yml file for the player
    public static void createPlayerData(Player p) {
        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("EssentialFeatures").getDataFolder(), File.separator + "users_data");
        File f = new File(userdata, File.separator + p.getName() +".yml");
        playerData = YamlConfiguration.loadConfiguration(f);
        if(!f.exists()) {
            try {

                playerData.save(f);
            } catch (IOException exception) {

                exception.printStackTrace();
            }
        }
    }

    // Gets the .yml file of a player
    public static FileConfiguration GetPlayerData(Player p) {
        String playerName = p.getName();
        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("EssentialFeatures").getDataFolder(), File.separator + "users_data");
        File f = new File(userdata, File.separator + playerName + ".yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(f);
        return config;
    }

    // Saves the player's .yml file
    public static void savePlayerData(Player p) {
        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("EssentialFeatures").getDataFolder(), File.separator + "users_data");
        File f = new File(userdata, File.separator + p.getName() +".yml");
        try {
            playerData.save(f);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
