package me.xbones.essentialfeatures.events;

import me.xbones.essentialfeatures.EssentialFeatures;
import me.xbones.essentialfeatures.inventories.BarInventory;
import me.xbones.essentialfeatures.player.EPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BarInventoryClickListener implements Listener {

    // VARIABLES //
    private EssentialFeatures main;
    // VARIABLES //

    // CONSTRUCTOR
    public BarInventoryClickListener(EssentialFeatures main) {
        this.main = main;
    }

    // INVENTORY CLICK EVENT
    @EventHandler
    public void onItemClick(InventoryClickEvent e) {
        Inventory inventory = e.getInventory();
        ItemStack item = e.getCurrentItem();
        EPlayer player = new EPlayer(Bukkit.getPlayer(e.getWhoClicked().getUniqueId()).getUniqueId());
        BarInventory barinventory = new BarInventory(main);
        if(inventory.getName().equalsIgnoreCase(barinventory.getBar().getName())) {

        }
    }
}
