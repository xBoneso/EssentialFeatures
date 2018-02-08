package me.xbones.essentialfeatures.holograms;

import org.bukkit.Location;
import org.bukkit.World;

import java.util.List;

// HOLOGRAM MANAGER CLASS
public class Holograms {

    // VARIABLES //
    // VARIABLES //

    public void createHologram(World w, Location loc, String name, List<String> lines) {
        Hologram hologram = new Hologram(w, loc, name, lines);
        hologram.show();
    }
}
