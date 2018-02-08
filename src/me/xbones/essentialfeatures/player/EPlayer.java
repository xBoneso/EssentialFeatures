package me.xbones.essentialfeatures.player;

import me.xbones.essentialfeatures.utils.PlayerUtils;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import java.util.*;

public class EPlayer {

    // VARIABLES //
    private UUID uuid;
    // VARIABLES //

    // CONSTRUCTOR
    public EPlayer(UUID uuid) {
        this.uuid = uuid;
    }

    // Gets the player's .yml file
    public FileConfiguration getPlayerData() {
        return PlayerUtils.GetPlayerData(Bukkit.getPlayer(uuid));
    }

    // Gets the player
    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }
}
