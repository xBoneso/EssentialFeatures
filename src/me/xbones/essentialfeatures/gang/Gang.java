package me.xbones.essentialfeatures.gang;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Gang {
    private String name;

    private UUID owner;

    private String prefix;

    private List<UUID> players = new ArrayList<>();

    public String getName() {
        return name;
    }

    public UUID getOwner() {
        return owner;
    }

    public void setOwner(UUID newOwner) {
        this.owner = newOwner;
    }

    public List<UUID> getPlayers() {
        return players;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gang getGang() {
        return this;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
