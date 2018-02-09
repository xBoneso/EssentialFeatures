package me.xbones.essentialfeatures.events;

import me.xbones.essentialfeatures.EssentialFeatures;
import me.xbones.essentialfeatures.utils.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.server.ServerListPingEvent;

public class DamageIndicatorsListener implements Listener {

    // VARIABLES //
    private EssentialFeatures main;
    // VARIABLES //

    // CONSTRUCTOR
    public DamageIndicatorsListener(EssentialFeatures main) {
        this.main = main;
    }

    // DAMAGE INDICATORS LISTENERS
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDamaged(EntityDamageEvent e) {

    }
}
