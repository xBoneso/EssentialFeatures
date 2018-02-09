package me.xbones.essentialfeatures.inventories;

import me.xbones.essentialfeatures.EssentialFeatures;
import me.xbones.essentialfeatures.utils.InventoryUtils;
import me.xbones.essentialfeatures.utils.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

// GUI OF THE BLOCKCOMMANDS
public class BlockCommandsInventory {

    // VARIABLES //
    private EssentialFeatures main;
    private Inventory gui;
    // VARIABLES //

    // CONSTRUCTOR
    public BlockCommandsInventory(EssentialFeatures main) {
        this.main = main;
    }
    public void InitializeGUI() {
        gui = Bukkit.createInventory(null, 54, TextUtils.color("&aBlock Commands"));
        InventoryUtils utils = new InventoryUtils();
    }
}
