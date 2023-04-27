package sh.solsk.drx;

import com.jeff_media.updatechecker.UpdateCheckSource;
import com.jeff_media.updatechecker.UpdateChecker;
import com.jeff_media.updatechecker.UserAgentBuilder;
import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import sh.solsk.drx.commands.DailyCommand;
import sh.solsk.drx.managers.PlayerManager;
import sh.solsk.drx.managers.TimeHandler;
import sh.solsk.drx.managers.files.FileManager;
import sh.solsk.drx.managers.files.FileType;
import sh.solsk.drx.managers.gui.DailyRewardGUI;

public class DailyRX extends JavaPlugin {

    private static DailyRX dailyRX;

    private FileManager fileManager;
    private DailyRewardGUI dailyRewardGUI;
    private TimeHandler timeHandler;
    private PlayerManager playerManager;

    private BukkitCommandManager<CommandSender> commandManager;

    private static final int RESOURCE_ID = 0;

    public void onEnable() {
        // Plugin startup logic

        dailyRX = this;

        fileManager = new FileManager(this);
        dailyRewardGUI = new DailyRewardGUI();
        timeHandler = new TimeHandler();
        playerManager = new PlayerManager();

        commandManager = BukkitCommandManager.create(this);
        // Check for plugin updates from SpigotMC.
        checkUpdate();

        commandManager.registerCommand(new DailyCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        fileManager.saveFile(FileType.CONFIG);
        fileManager.saveFile(FileType.MESSAGES);
        fileManager.saveFile(FileType.BONUS);
    }

    public static DailyRX getDailyRX() {
        return dailyRX;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public DailyRewardGUI getDailyRewardGUI() {
        return dailyRewardGUI;
    }

    public TimeHandler getTimeHandler() {
        return timeHandler;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public void checkUpdate() {
        new UpdateChecker(this, UpdateCheckSource.CUSTOM_URL, "https://solsk.sh/api/dailybonus-latest.txt")
                .setDownloadLink("")
                .setChangelogLink("")
                .setNotifyOpsOnJoin(true)
                .setNotifyByPermissionOnJoin("drx.update")
                .setSupportLink("https://solsk.sh/discord")
                .setUserAgent(new UserAgentBuilder().addPluginNameAndVersion())
                .checkEveryXHours(12)
                .checkNow();
    }
}
