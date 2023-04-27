package sh.solsk.drx.managers.files;

import ch.jalu.configme.Comment;
import ch.jalu.configme.configurationdata.CommentsConfiguration;
import ch.jalu.configme.properties.Property;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

import static ch.jalu.configme.properties.PropertyInitializer.newListProperty;
import static ch.jalu.configme.properties.PropertyInitializer.newProperty;

public class ConfigManager {

    public ConfigManager() {}

    public void registerComments(CommentsConfiguration commentsConfiguration) {
        String[] header = {
                "Github: https://github.com/solsk-sh/DailyBonus",
                "",
                "Issues/Features/Suggestions: https://github.com/solsk-sh/DailyBonus/issues"
        };
        commentsConfiguration.setComment("settings", header);
    }

    @Comment("")
    public static final Property<String> PREFIX = newProperty("settings.prefix", "&#e85d04&l[&#ffd60a&lDailyBonus&#1982c4&lX&#e85d04&l]");

    @Comment("")
    public static final Property<Boolean> CHECK_UPDATES_ENABLED = newProperty("settings.check-updates", true);

    @Comment("")
    public static final Property<Boolean> AUTOCLAIM_ENABLED = newProperty("settings.autoclaim.enabled", true);

    @Comment("")
    public static final Property<Boolean> AUTOCLAIM_NOTIFY_ONCLAIM = newProperty("settings.autoclaim.notify-onclaim", true);

    @Comment("")
    public static final Property<Boolean> BONUS_REMINDER_ENABLED = newProperty("settings.bonus-reminder", true);

    @Comment("")
    public static final Property<String> GUI_TITLE = newProperty("gui.title", "&#75B3FFDailyBonus");

    @Comment("")
    public static final Property<String> GUI_FILLER_NAME = newProperty("gui.filler.name", " ");

    @Comment("")
    public static final Property<String> GUI_FILLER_MATERIAL = newProperty("gui.filler.material", "minecraft:black_stained_glass_pane");

    @Comment("")
    public static final Property<Integer> STREAK_LIMIT = newProperty("settings.reward-limit", 30);

    @Comment("")
    public static final Property<String> PRESET_NOT_READY_MATERIAL = newProperty("presets.not-ready.material", "BLACK_CONCRETE");
    public static final Property<String> PRESET_NOT_READY_NAME = newProperty("presets.not-ready.name", "BLACK_CONCRETE");
    public static final Property<Boolean> PRESET_NOT_READY_ENCHANTED = newProperty("presets.not-ready.enchanted", false);
    public static final Property<Boolean> PRESET_NOT_READY_GLOWING = newProperty("presets.not-ready.glowing", false);
    public static final Property<List<String>> PRESET_NOT_READY_LORE = newListProperty("settings.not-ready.lore", List.of("", ""));






}
