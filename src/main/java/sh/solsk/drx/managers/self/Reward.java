package sh.solsk.drx.managers.self;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Reward {

    private final String itemName;
    private final ItemStack itemStack;
    private final List<String> messages, commands;
    private final Integer slotNumber;

    public Reward(String itemName, ItemStack itemStack, List<String> messages, List<String> commands, Integer slotNumber) {

        this.itemName = itemName;
        this.itemStack = itemStack;
        this.messages = messages;
        this.commands = commands;
        this.slotNumber = slotNumber;

    }

}
