package sh.solsk.drx.commands;

import dev.triumphteam.cmd.bukkit.annotation.Permission;
import dev.triumphteam.cmd.core.BaseCommand;
import dev.triumphteam.cmd.core.annotation.Command;
import dev.triumphteam.cmd.core.annotation.Default;
import dev.triumphteam.cmd.core.annotation.SubCommand;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionDefault;
import sh.solsk.drx.DailyRX;
import sh.solsk.drx.managers.files.FileManager;

@Command(value = "drx", alias = {"dailyb", "dbonus"})
public class DailyCommand extends BaseCommand {

    private final DailyRX dailyRX = DailyRX.getDailyRX();

    FileManager fileManager = dailyRX.getFileManager();

    @Default
    @Permission(value = "drx.daily", def = PermissionDefault.TRUE)
    public void onDefault(Player player) {

    }

    @SubCommand("help")
    public void onHelp(Player player) {

    }

    @SubCommand("claim")
    @Permission(value = "drx.claim", def = PermissionDefault.TRUE)
    public void onClaim(Player player) {
        dailyRX.getDailyRewardGUI().openRewardGUI(player);
    }



}
