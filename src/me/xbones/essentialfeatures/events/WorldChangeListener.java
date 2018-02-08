package me.xbones.essentialfeatures.events;

import me.xbones.essentialfeatures.EssentialFeatures;
import me.xbones.essentialfeatures.utils.TextUtils;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class WorldChangeListener implements Listener {

    // VARIABLES //
    private EssentialFeatures main;
    // VARIABLES //

    // CONSTRUCTOR
    public WorldChangeListener(EssentialFeatures main) {
        this.main = main;
    }

    // WORLD CHANGED EVENT
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onWorldChange(org.bukkit.event.player.PlayerChangedWorldEvent e) {
        World w = e.getPlayer().getWorld();
        String gamemode = main.getConfig().getString("Worlds." + w.getName());
        if(gamemode.equalsIgnoreCase("creative")) {
            e.getPlayer().setGameMode(GameMode.CREATIVE);
        } else if (gamemode.equalsIgnoreCase("survival")) {
            e.getPlayer().setGameMode(GameMode.SURVIVAL);
        }
        else if (gamemode.equalsIgnoreCase("spectator")) {
            e.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
        else if (gamemode.equalsIgnoreCase("adventure")) {
            e.getPlayer().setGameMode(GameMode.ADVENTURE);
        }
    }
}
