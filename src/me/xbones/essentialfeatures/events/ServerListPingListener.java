package me.xbones.essentialfeatures.events;

import me.xbones.essentialfeatures.EssentialFeatures;
import me.xbones.essentialfeatures.utils.TextUtils;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class ServerListPingListener implements Listener {

    // VARIABLES //
    private EssentialFeatures main;
    // VARIABLES //

    // CONSTRUCTOR
    public ServerListPingListener(EssentialFeatures main) {
        this.main = main;
    }

    // SERVER LIST PING EVENT
    @EventHandler(priority = EventPriority.HIGHEST)
    public void ChangeMOTD(final org.bukkit.event.server.ServerListPingEvent event){
        event.setMotd(TextUtils.color(main.getConfig().getString("Server MOTD")));
    }
}
