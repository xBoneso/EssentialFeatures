package me.xbones.essentialfeatures.events;

import me.xbones.essentialfeatures.EssentialFeatures;
import me.xbones.essentialfeatures.utils.PlayerUtils;
import me.xbones.essentialfeatures.utils.TextUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class PlayerJoinListener implements Listener {

    // VARIABLES //
    private EssentialFeatures main;
    // VARIABLES //

    // CONSTRUCTOR
    public PlayerJoinListener(EssentialFeatures main) {
        this.main = main;
    }

    // PLAYER LOGIN EVENT
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerLogin(org.bukkit.event.player.PlayerJoinEvent e) {
        PlayerUtils.createPlayerData(e.getPlayer());
        if (!(e.getPlayer().hasPlayedBefore())) {
            String joinMessage = main.getConfig().getString("Unique Join Message");
            int Unique = main.getConfig().getInt("Unique");
            main.getConfig().set("Unique", Unique += 1);
            main.saveConfig();
            String message = joinMessage.replace("%player%", e.getPlayer().getName());
            e.setJoinMessage(TextUtils.color(message.replace("%id%", Integer.toString(Unique))));
        } else {
            String joinMessage = main.getConfig().getString("Join Message").replace("%player%", e.getPlayer().getName());
            e.setJoinMessage(TextUtils.color(joinMessage));
        }

    }
}
