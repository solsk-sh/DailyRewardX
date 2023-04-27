package sh.solsk.drx.managers.files;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import sh.solsk.drx.DailyRX;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FileManager {

    private FileConfiguration configuration, messages, bonus;

    private final DailyRX dailyBonus;
    private Map<FileType, File> fileMap;


    public FileManager(DailyRX dailyBonus) {

        this.dailyBonus = dailyBonus;

        File configurationFile = new File(dailyBonus.getDataFolder() + "/config.yml");
        File messagesFile = new File(dailyBonus.getDataFolder() + "/messages.yml");
        File bonusFile = new File(dailyBonus.getDataFolder() + "/rewards.yml");

        this.fileMap = new HashMap<>();
        fileMap.put(FileType.CONFIG, configurationFile);
        fileMap.put(FileType.MESSAGES, messagesFile);
        fileMap.put(FileType.BONUS, bonusFile);

        this.configuration = YamlConfiguration.loadConfiguration(fileMap.get(FileType.CONFIG));
        this.messages = YamlConfiguration.loadConfiguration(fileMap.get(FileType.MESSAGES));
        this.bonus = YamlConfiguration.loadConfiguration(fileMap.get(FileType.BONUS));
    }

    public FileConfiguration getPlayer(UUID playerId) {
        if (!playerDataExists(playerId)) {

        }
        return YamlConfiguration.loadConfiguration(new File(dailyBonus.getDataFolder() + "/players/" + playerId.toString() + ".yml"));
    }

    public boolean playerDataExists(UUID playerId) {
        return new File(dailyBonus.getDataFolder() + "/players/" + playerId.toString() + ".yml").exists();
    }

    public FileConfiguration createPlayerData(UUID playerId) {
        return YamlConfiguration.loadConfiguration(new File(dailyBonus.getDataFolder() + "/players/" + playerId.toString() + ".yml"));
    }

    public FileConfiguration getPlayerData(UUID playerId) {
        if(playerDataExists(playerId)) {
            return createPlayerData(playerId);
        }
        return getPlayerData(playerId);
    }

    public FileConfiguration getConfiguration() {
        return configuration;
    }

    public FileConfiguration getMessages() {
        return messages;
    }

    public FileConfiguration getBonuses() {
        return bonus;
    }

    public void reloadAll() {
        this.configuration = YamlConfiguration.loadConfiguration(new File(dailyBonus.getDataFolder() + "/config.yml"));
        this.messages = YamlConfiguration.loadConfiguration(new File(dailyBonus.getDataFolder() + "/messages.yml"));
        this.bonus = YamlConfiguration.loadConfiguration(new File(dailyBonus.getDataFolder() + "/rewards.yml"));
    }

    public void reload(FileType fileType) {
        switch (fileType) {
            case CONFIG:
                this.configuration = YamlConfiguration.loadConfiguration(new File(dailyBonus.getDataFolder() + "/config.yml"));
            case MESSAGES:
                this.messages = YamlConfiguration.loadConfiguration(new File(dailyBonus.getDataFolder() + "/messages.yml"));
            case BONUS:
                this.bonus = YamlConfiguration.loadConfiguration(new File(dailyBonus.getDataFolder() + "/rewards.yml"));
        }
    }

    public boolean saveFile(FileType fileType) {
        FileConfiguration fileConfiguration = getConfiguration();

        try {
            fileConfiguration.save(fileMap.get(fileType));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Map<FileType, File> getFileMap() {
        return fileMap;
    }
}
