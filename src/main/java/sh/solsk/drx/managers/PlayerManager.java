package sh.solsk.drx.managers;

import org.bukkit.entity.Player;
import sh.solsk.drx.DailyRX;
import sh.solsk.drx.managers.files.FileManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerManager {

    private final DailyRX dailyRX;
    private final FileManager fileManager;
    private Boolean autoClaimEnabled;
    private final Map<Player, Long> playerTimeMap;
    private final List<Player> bonusReminder, autoClaimList;

    public PlayerManager() {
        dailyRX = DailyRX.getDailyRX();
        fileManager = dailyRX.getFileManager();

        this.autoClaimEnabled = dailyRX.getFileManager().getConfiguration().getBoolean("settings.autoclaim.enabled");

        playerTimeMap = new HashMap<>();
        bonusReminder = new ArrayList<>();
        autoClaimList = new ArrayList<>();

    }

    public void createMapEntry(Player player) {
        playerTimeMap.put(player, dailyRX.getTimeHandler().getCurrentMillis());
    }

    public void deleteMapEntry(Player player) {
        playerTimeMap.remove(player);
    }

    public Map<Player, Long> getPlayerTimeMap() {
        return playerTimeMap;
    }

    public List<Player> getBonusReminder() {
        return bonusReminder;
    }

    public Boolean getAutoClaimEnabled() {
        return autoClaimEnabled;
    }

    public void setAutoClaimEnabled(Boolean autoClaimEnabled) {
        this.autoClaimEnabled = autoClaimEnabled;
    }

    public List<Player> getAutoClaimList() {
        return autoClaimList;
    }

    private boolean hasAutoClaimPermission(Player player) {
        return player.hasPermission("drx.autoclaim");
    }

    public boolean canAutoClaim(Player player) {
        return autoClaimList.contains(player);
    }

    public void loadPlayer(Player player) {

        createMapEntry(player);

        if (autoClaimEnabled) {
            if (hasAutoClaimPermission(player)) autoClaimList.add(player);
        }

    }

    public void unloadPlayer(Player player) {
        if (autoClaimList.contains(player)) autoClaimList.remove(player);
        deleteMapEntry(player);
    }

    public void setupPlayer() {

    }
}
