package sh.solsk.drx.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import sh.solsk.drx.DailyRX;
import sh.solsk.drx.managers.PlayerManager;
import sh.solsk.drx.managers.files.FileManager;

public class ConnectionEvents implements Listener {

    // Join Leave Events
    DailyRX dailyRX = DailyRX.getDailyRX();

    private FileManager fileManager = dailyRX.getFileManager();
    private PlayerManager playerManager = dailyRX.getPlayerManager();

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        // Run plugin update checker task asynchronously.

        playerManager.loadPlayer(player);


        // Check for plugin update on api.solsk.sh/spigot/
        if(player.isOp() || player.hasPermission("")) {
            dailyRX.checkUpdate();
        }

    }


}
