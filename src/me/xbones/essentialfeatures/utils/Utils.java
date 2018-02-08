package me.xbones.essentialfeatures.utils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import me.xbones.essentialfeatures.gang.Gang;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Utils {

    // VARIABLES //
    private FileConfiguration gConfig;
    // VARIABLES //

    // Creates the gangs.yml
    public void createGangsYML() {
        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("EssentialFeatures").getDataFolder(), File.separator + "data");
        File f = new File(userdata, File.separator + "gangs.yml");
        gConfig = YamlConfiguration.loadConfiguration(f);
        if(!f.exists()) {
            try {

                gConfig.save(f);
            } catch (IOException exception) {

                exception.printStackTrace();
            }
        }
    }

    // Saves the gangs.yml
    public void saveGangsYML() {
        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("EssentialFeatures").getDataFolder(), File.separator + "data");
        File f = new File(userdata, File.separator + "gangs.yml");
        try {
            gConfig.save(f);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Saves gangs into the gangs.yml
    public void saveGangs(List<Gang> gangs) {
        for(Gang g : gangs) {
            gConfig.set("Gangs." + g.getName() + ".owner", g.getOwner());
            gConfig.set("Gangs." + g.getName() + ".players", g.getPlayers());
            gConfig.set("Gangs." + g.getName() + ".name", g.getName());
            gConfig.set("Gangs." + g.getName() + ".prefix", g.getPrefix());
            saveGangsYML();
        }
    }

    // Gets the gangs from gangs.yml
    public List<Gang> getGangs() {
        List<Gang> partylist2 = new ArrayList<Gang>();
        for (String key : gConfig.getConfigurationSection("Gangs").getKeys(false)) {
            ConfigurationSection section = gConfig.getConfigurationSection("Gangs." + key);
            Gang g = new Gang();
            g.setPrefix(gConfig.getString("prefix"));
            g.setOwner(UUID.fromString(section.getString("owner")));
            g.setName(section.getString("name"));
            Stream<UUID> playerStream = gConfig.getStringList("players").stream().map(UUID::fromString);
            g.getPlayers().addAll(playerStream.collect(Collectors.toList()));
            partylist2.add(g);
        }
        return partylist2;
    }
}
