package me.xbones.essentialfeatures.holograms;


import me.xbones.essentialfeatures.utils.TextUtils;
import org.bukkit.*;
import org.bukkit.entity.*;
import java.util.*;

// HOLOGRAM CLASS
public class Hologram {

    // VARIABLES //
    private String name;
    private List<String> lines;
    private List<ArmorStand> armorStands = new ArrayList<>();
    private Location loc;
    private World w;
    // VARIABLES //

    // CONSTRUCTOR
    public Hologram(World w, Location loc, String name, List<String> lines) {
        this.name = name;
        this.lines = lines;
        this.w = w;
        this.loc = loc;
    }

    public void show() {
        for(String s : lines) {
            Entity entity = w.spawnEntity(loc, EntityType.ARMOR_STAND);
            ArmorStand armorStand = (ArmorStand) entity;
            armorStand.setVisible(false);   
            armorStand.setCustomName(TextUtils.color(s));
            armorStand.setCustomNameVisible(true);
            armorStands.add(armorStand);
        }
    }

    public void delete() {
        for(ArmorStand as : armorStands) {
            as.remove();
        }
    }
}
