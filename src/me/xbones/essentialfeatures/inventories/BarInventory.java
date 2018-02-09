package me.xbones.essentialfeatures.inventories;

import me.xbones.essentialfeatures.EssentialFeatures;
import me.xbones.essentialfeatures.utils.InventoryUtils;
import me.xbones.essentialfeatures.utils.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

// GUI OF THE BAR
public class BarInventory {

    // VARIABLES //
    private EssentialFeatures main;
    private Inventory bar;
    // VARIABLES //

    // CONSTRUCTOR
    public BarInventory(EssentialFeatures main) {
        this.main = main;
}

    public Inventory getBar() {
         return bar;
    }

    public void InitializeGUI() {
        bar = Bukkit.createInventory(null, 9, TextUtils.color(main.getConfig().getString("Bar Title")));
        InventoryUtils utils = new InventoryUtils();
        utils.createDisplay(Material.STAINED_GLASS_PANE,  bar, 0, ChatColor.RED + "THE BARTENDER!", ChatColor.DARK_RED + "DO YOU HAVE ENOUGH LUCK?");
        utils.createDisplay(Material.POTION, bar, 1, ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Bar Items.1.Name")), ChatColor.translateAlternateColorCodes('&', "&aPrice: " + main.config.getInt("Bar Items.1.Price") + " \nWinning Prize: " + main.config.getInt("Bar Items.1.Prize")).replace("\\n", "\n"));
        utils.createDisplay(Material.POTION, bar, 2, ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Bar Items.2.Name")), ChatColor.translateAlternateColorCodes('&', "&aPrice: " + main.config.getInt("Bar Items.2.Price") + " \nWinning Prize: " + main.config.getInt("Bar Items.2.Prize")).replace("\\n", "\n"));
        utils.createDisplay(Material.POTION, bar, 3, ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Bar Items.3.Name")), ChatColor.translateAlternateColorCodes('&', "&aPrice: " + main.config.getInt("Bar Items.3.Price") + " \nWinning Prize: " + main.config.getInt("Bar Items.3.Prize")).replace("\\n", "\n"));
        utils.createDisplay(Material.POTION, bar, 4, ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Bar Items.4.Name")), ChatColor.translateAlternateColorCodes('&', "&aPrice: " + main.config.getInt("Bar Items.4.Price") + " \nWinning Prize: " + main.config.getInt("Bar Items.4.Prize")).replace("\\n", "\n"));
        utils.createDisplay(Material.POTION, bar, 5, ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Bar Items.5.Name")), ChatColor.translateAlternateColorCodes('&', "&aPrice: " + main.config.getInt("Bar Items.5.Price") + " \nWinning Prize: " + main.config.getInt("Bar Items.5.Prize")).replace("\\n", "\n"));
        utils.createDisplay(Material.POTION, bar, 6, ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Bar Items.6.Name")), ChatColor.translateAlternateColorCodes('&', "&aPrice: " + main.config.getInt("Bar Items.6.Price") + " \nWinning Prize: " + main.config.getInt("Bar Items.6.Prize")).replace("\\n", "\n"));
        utils.createDisplay(Material.POTION, bar, 7, ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Bar Items.7.Name")), ChatColor.translateAlternateColorCodes('&', "&aPrice: " + main.config.getInt("Bar Items.7.Price") + " \nWinning Prize: " + main.config.getInt("Bar Items.7.Prize")).replace("\\n", "\n"));
        utils.createDisplay(Material.STAINED_GLASS_PANE, bar, 8, ChatColor.RED + "THE BARTENDER!", ChatColor.DARK_RED + "DO YOU HAVE ENOUGH LUCK?");
    }
}
