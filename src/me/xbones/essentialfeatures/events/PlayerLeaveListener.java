package me.xbones.essentialfeatures.events;

import me.xbones.essentialfeatures.EssentialFeatures;
import me.xbones.essentialfeatures.utils.TextUtils;
import org.apache.logging.log4j.core.net.Priority;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class PlayerLeaveListener implements Listener {

    // VARIABLES //
    private EssentialFeatures main;
    // VARIABLES //

    // CONSTRUCTOR
    public PlayerLeaveListener(EssentialFeatures main) {
        this.main = main;
    }

    // PLAYER LEAVE EVENT
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerLeave(org.bukkit.event.player.PlayerQuitEvent e) {
        String leaveMessage = main.getConfig().getString("Leave Message").replace("%player%", e.getPlayer().getName());
        e.setQuitMessage(TextUtils.color(leaveMessage));
    }
}
