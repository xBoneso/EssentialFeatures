package me.xbones.essentialfeatures.events;

import me.xbones.essentialfeatures.EssentialFeatures;
import me.xbones.essentialfeatures.utils.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class CreateScoreboardListener implements Listener {

    // VARIABLES //
    private EssentialFeatures main;
    // VARIABLES //

    // CONSTRUCTOR
    public CreateScoreboardListener(EssentialFeatures main) {
        this.main = main;
    }

    // PLAYER LOGIN EVENT
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerLogin(org.bukkit.event.player.PlayerJoinEvent e) {
        String title = TextUtils.color(main.config.getString("Scoreboard.Title"));
        String line1 = TextUtils.color(main.config.getString("Scoreboard.Lines.1"));
        String line2 = TextUtils.color(main.config.getString("Scoreboard.Lines.2"));
        String line3 = TextUtils.color(main.config.getString("Scoreboard.Lines.3"));
        String line4 = TextUtils.color(main.config.getString("Scoreboard.Lines.4"));
        String line5 = TextUtils.color(main.config.getString("Scoreboard.Lines.5"));
        String line6 = TextUtils.color(main.config.getString("Scoreboard.Lines.6"));
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective("showhealth", "health");
        objective.setDisplaySlot(DisplaySlot.BELOW_NAME);
        objective.setDisplayName(TextUtils.color("&c/ 20"));

        for(Player online : Bukkit.getOnlinePlayers()){
            online.setScoreboard(board);
            online.setHealth(online.getHealth()); //Update their health
        }

    }

    public void registerScoreboard(Player p)
    {
        String title = TextUtils.color(main.config.getString("Scoreboard.Title"));
        String line1 = TextUtils.color(main.config.getString("Scoreboard.Lines.1"));
        String line2 = TextUtils.color(main.config.getString("Scoreboard.Lines.2"));
        String line3 = TextUtils.color(main.config.getString("Scoreboard.Lines.3"));
        String line4 = TextUtils.color(main.config.getString("Scoreboard.Lines.4"));
        String line5 = TextUtils.color(main.config.getString("Scoreboard.Lines.5"));
        String line6 = TextUtils.color(main.config.getString("Scoreboard.Lines.6"));
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective("showscoreboard", "scoreboard");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        p.setScoreboard(board);
    }
}
