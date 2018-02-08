package me.xbones.essentialfeatures.events;

import me.xbones.essentialfeatures.EssentialFeatures;
import me.xbones.essentialfeatures.utils.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.server.ServerListPingEvent;

public class MaxPlayersListener implements Listener {

    // VARIABLES //
    private EssentialFeatures main;
    // VARIABLES //

    // CONSTRUCTOR
    public MaxPlayersListener(EssentialFeatures main) {
        this.main = main;
    }

    // MAX PLAYERS EVENT LISTENERS
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerLoginEvent e) {
        if (Bukkit.getOnlinePlayers().size() < main.getConfig().getInt("Max Players")) {
            e.allow();
        } else {
            e.disallow(PlayerLoginEvent.Result.KICK_FULL, TextUtils.color("&cSorry but the server is full!"));
        }
    }
    @EventHandler(priority=EventPriority.HIGHEST)
    public void onServerListPing(ServerListPingEvent e) {
        e.setMaxPlayers(main.getConfig().getInt("Max Players"));
    }
}
