package sh.solsk.drx.managers.gui;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import sh.solsk.drx.DailyRX;
import sh.solsk.drx.managers.files.ConfigManager;

public class DailyRewardGUI {

    private final DailyRX dailyRX = DailyRX.getDailyRX();
    private FileConfiguration configuration = dailyRX.getFileManager().getConfiguration();


    public void openRewardGUI(Player player) {
        Gui rewardGui = Gui.gui()
                .title(Component.text(configuration.getString("gui.settings.title"))) // get title
                .rows(6)
                .create();

        rewardGui.getFiller().fill(ItemBuilder.from(new ItemStack(Material.valueOf(configuration.getString("presets.unclaimed.material")))).asGuiItem());

        GuiItem fillerItem = ItemBuilder.from(Material.valueOf(ConfigManager.GUI_FILLER_MATERIAL.toString())).asGuiItem(event -> {
            event.setCancelled(true);
            ((Player) event.getWhoClicked()).playSound(event.getWhoClicked().getLocation(), Sound.UI_BUTTON_CLICK, 1, 1);
        });

        Integer[] fillerSlots = {0, 1, 2, 3, 5, 6, 7, 8, 9, 17, 18, 26, 27, 35, 36, 44, 45, 46, 47, 48, 50, 51, 52, 53};

        rewardGui.setItem(4, fillerItem);
        for (int i = 0; i < 54; i++) {
            rewardGui.setItem(i, fillerItem);
        }
        for (int i = 18; i < 26; i++) {
            rewardGui.setItem(i, fillerItem);
        }
        for (int i = 27; i < 35; i++) {
            rewardGui.setItem(i, fillerItem);
        }
        for (int i = 36; i < 44; i++) {
            rewardGui.setItem(i, fillerItem);
        }
        rewardGui.setItem(49, fillerItem);

        rewardGui.open(player);
    }


}
