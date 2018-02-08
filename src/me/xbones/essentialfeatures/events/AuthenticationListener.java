package me.xbones.essentialfeatures.events;

import me.xbones.essentialfeatures.EssentialFeatures;
import me.xbones.essentialfeatures.utils.TextUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class AuthenticationListener implements Listener {

    // VARIABLES //
    private EssentialFeatures main;
    // VARIABLES //

    // CONSTRUCTOR
    public AuthenticationListener(EssentialFeatures main) {
        this.main = main;
    }

    // PLAYER JOIN EVENT
    @EventHandler
    public void onPlayerLogin(org.bukkit.event.player.PlayerJoinEvent e) {

        // WIP
    }
}
