package me.xbones.essentialfeatures;

import me.xbones.essentialfeatures.commands.EFCommand;
import me.xbones.essentialfeatures.commands.GameModeCMD;
import me.xbones.essentialfeatures.commands.GangCommand;
import me.xbones.essentialfeatures.events.*;
import me.xbones.essentialfeatures.gang.Gang;
import me.xbones.essentialfeatures.utils.DiscordUtils;
import me.xbones.essentialfeatures.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class EssentialFeatures extends JavaPlugin {

    // VARIABLES //
    private ConsoleCommandSender clogger = this.getServer().getConsoleSender();
    private Utils utils = new Utils();
    private DiscordUtils discordUtils = new DiscordUtils(this);
    private List<Gang> gangs = new ArrayList<>();
    private String prefix;
    private EssentialFeatures main;
    // VARIABLES //

    //onEnable of EssentialFeatures
    @Override
    public void onEnable() {
        main = this;
       // gangs = utils.getGangs();
        this.getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        getVariables();
        registerCommands();
        registerEvents();
        enableModules();
        clogger.sendMessage(ChatColor.RED + "---------------------------------------");
        clogger.sendMessage(ChatColor.GREEN + "EssentialFeatures successfully enabled!");
        clogger.sendMessage(ChatColor.RED + "---------------------------------------");
    }

    // REGISTERS COMMANDS
    public void registerCommands() {
        this.getCommand("ef").setExecutor(new EFCommand(this));
        this.getCommand("gang").setExecutor(new GangCommand(this));
        this.getCommand("gms").setExecutor(new GameModeCMD(this));
        this.getCommand("gmc").setExecutor(new GameModeCMD(this));
        this.getCommand("gmsp").setExecutor(new GameModeCMD(this));
        this.getCommand("gma").setExecutor(new GameModeCMD(this));
    }

    // REGISTERS EVENTS
    public void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerLeaveListener(this), this);
        if(this.getConfig().getBoolean("Enabled Modules.PerWorldGameMode"))
            this.getServer().getPluginManager().registerEvents(new WorldChangeListener(this), this);
        this.getServer().getPluginManager().registerEvents(new ServerListPingListener(this), this);
        this.getServer().getPluginManager().registerEvents(new MaxPlayersListener(this), this);
    }

    // GET ALL VARIABLES
    public void getVariables() {
        prefix = this.getConfig().getString("Prefix");
    }

    // ENABLES MODULES
    public void enableModules() {
        if(this.getConfig().getBoolean("Enabled Modules.Discord.Enabled")) {
            discordUtils.setupDiscordBot();
        }
        if(this.getConfig().getBoolean("Enabled Modules.Gangs")){
            utils.createGangsYML();
        }
        if(this.getConfig().getBoolean("Enabled Modules.PerWorldGameMode")) {
            for(World w : Bukkit.getWorlds()) {
                this.getConfig().set("Worlds." + w.getName(), "SURVIVAL");
                saveDefaultConfig();
            }
        }
    }

    public List<Gang> getGangs() {return gangs;}
    public String getPrefix() { return prefix;}
}
