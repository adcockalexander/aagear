package aagear.utility;

import aagear.rarity.Rarity;
import aagear.rarity.RarityMapper;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class LevelParser {

    private static final String level0String = ChatColor.DARK_AQUA + "Level 0 [" + ChatColor.DARK_GRAY + "||||||||||||||||||||"
            + ChatColor.DARK_AQUA + "] 0 / 1000 XP";

    private static final String level100String = ChatColor.DARK_AQUA + "Level 50 - " + ChatColor.RED + "Maxed!";

    public static String getLevel0String() {
        return level0String;
    }

    // Returns -1 if item remains the same level, else returns the new level
    public static int addXPIfEligible(Player ply, ItemStack item, int xp) {
        ItemMeta itemMeta = item.getItemMeta();

        if (itemMeta == null) return -1;

        List<String> lore = itemMeta.getLore();

        if (lore == null) return -1;

        int listCounter = 0;

        while (listCounter < lore.size()) {
            String loreLine = lore.get(listCounter);

            if (loreLine.length() >= 7) { // Prevent string exceptions
                if (loreLine.startsWith("Level", 2)) {
                    // Parse current level
                    int charPointer = 8;

                    int level = 0;

                    // Parse out the current level into a variable
                    while (loreLine.charAt(charPointer) != ' ') {
                        level *= 10;
                        level += loreLine.charAt(charPointer) - '0';
                        charPointer++;
                    }

                    if (level == 50) return -1;

                    charPointer += 26; // skip char pointer to the earliest spot the bracket can be at

                    // move until we find the closing bracket of the XP bar
                    while (loreLine.charAt(charPointer) != ']') {
                        charPointer++;
                    }

                    charPointer += 2; // move char pointer to the start of the XP amount

                    int xpAmount = 0;

                    // Parse out the current XP amount into a variable
                    while (loreLine.charAt(charPointer) != ' ') {
                        xpAmount *= 10;
                        xpAmount += loreLine.charAt(charPointer) - '0';
                        charPointer++;
                    }

                    xpAmount += xp;

                    int requiredXP = getXPToNextLevel(level);

                    boolean levelUp = (xpAmount >= requiredXP);

                    if (levelUp) { // Level up
                        if (level == 49) {
                            lore.set(listCounter, level100String);

                            message(ply, "Your " + itemMeta.getDisplayName() + ChatColor.RESET + " levelled up to " +
                                    ChatColor.DARK_AQUA + "Level 50" + ChatColor.RESET + "!");
                            message(ply, ChatColor.RED + "Congratulations on maxing your tool!");

                            for (Player target : Bukkit.getOnlinePlayers()) {
                                message(target, ply.getName() + ChatColor.RED + " has maxed their " + itemMeta.getDisplayName()
                                 + ChatColor.RED + "!");
                            }
                        } else {
                            String levelString = getLevelString(level + 1, xpAmount - requiredXP, getXPToNextLevel(level + 1));

                            lore.set(listCounter, levelString);

                            message(ply, "Your " + itemMeta.getDisplayName() + ChatColor.RESET + " levelled up to " +
                                    ChatColor.DARK_AQUA + "Level " + (level + 1) + ChatColor.RESET + "!");

                            if (level % 10 == 9) {
                                for (Player target : Bukkit.getOnlinePlayers()) {
                                    message(target, ply.getName() + " has levelled their " + itemMeta.getDisplayName()
                                    + ChatColor.RESET + " to " + ChatColor.DARK_AQUA + "Level " + (level + 1) + ChatColor.RESET + "!");
                                }
                            }
                        }

                        itemMeta.setLore(lore);
                        item.setItemMeta(itemMeta);

                        return level + 1;
                    } else { // Don't level up
                        String levelString = getLevelString(level, xpAmount, requiredXP);

                        lore.set(listCounter, levelString);

                        itemMeta.setLore(lore);
                        item.setItemMeta(itemMeta);

                        return -1;
                    }
                }
            }

            listCounter++;
        }

        return -1;
    }

    // Returns the appropriate string to place inside an item's lore based on its level & XP
    private static String getLevelString(int level, int xp, int requiredXP) {
        StringBuilder sb = new StringBuilder();

        sb.append(ChatColor.DARK_AQUA);
        sb.append("Level ");
        sb.append(level);
        sb.append(" [");

        int blocks = 20;

        int remainingXP = xp;
        int xpForOneBlock = (requiredXP / blocks);

        int greenBlocks = 0;

        while (remainingXP >= xpForOneBlock) {
            greenBlocks++;
            remainingXP -= xpForOneBlock;
        }

        int grayBlocks = blocks - greenBlocks;

        sb.append(ChatColor.GREEN);

        while (greenBlocks > 0) {
            sb.append('|');
            greenBlocks--;
        }

        sb.append(ChatColor.DARK_GRAY);

        while (grayBlocks > 0) {
            sb.append('|');
            grayBlocks--;
        }

        sb.append(ChatColor.DARK_AQUA);
        sb.append("] ");

        sb.append(xp);
        sb.append(" / ");
        sb.append(requiredXP);
        sb.append(" XP");

        return sb.toString();
    }

    private static int getXPToNextLevel(int level) {
        return (int)(1000.0 * Math.pow(1.07, level));
    }

    private static void message(Player ply, String message) {
        ply.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Gear " + ChatColor.DARK_GRAY + ChatColor.BOLD +
                ">> " + ChatColor.RESET + message);
    }

    public static int getMaxLevel(ItemStack item) {
        Rarity rarity = RarityMapper.getItemRarity(item);

        if (rarity == Rarity.ONE_STAR) {
            return 5;
        } else if (rarity == Rarity.TWO_STARS) {
            return 10;
        } else if (rarity == Rarity.THREE_STARS) {
            return 20;
        } else if (rarity == Rarity.FOUR_STARS) {
            return 35;
        } else if (rarity == Rarity.FIVE_STARS) {
            return 50;
        }

        return -1;
    }

}
