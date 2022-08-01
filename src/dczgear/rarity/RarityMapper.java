package dczgear.rarity;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RarityMapper {

    public static Rarity getItemRarity(ItemStack item) {
        ItemMeta itemMeta = item.getItemMeta();

        if (itemMeta == null) return null;

        String name = itemMeta.getDisplayName();

        if (name.startsWith(ChatColor.WHITE + "" + ChatColor.BOLD)) {
            return Rarity.ONE_STAR;
        } else if (name.startsWith(ChatColor.GREEN + "" + ChatColor.BOLD)) {
            return Rarity.TWO_STARS;
        } else if (name.startsWith(ChatColor.BLUE + "" + ChatColor.BOLD)) {
            return Rarity.THREE_STARS;
        } else if (name.startsWith(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD)) {
            return Rarity.FOUR_STARS;
        } else if (name.startsWith(ChatColor.GOLD + "" + ChatColor.BOLD)) {
            return Rarity.FIVE_STARS;
        }

        return null;
    }

    public static String getRarityLine(Rarity rarity) {
        if (rarity == Rarity.ONE_STAR)
            return ChatColor.WHITE + "Rarity: " + ChatColor.GOLD + "" + ChatColor.BOLD + "✰";
        else if (rarity == Rarity.TWO_STARS)
            return ChatColor.WHITE + "Rarity: " + ChatColor.GOLD + "" + ChatColor.BOLD + "✰✰";
        else if (rarity == Rarity.THREE_STARS)
            return ChatColor.WHITE + "Rarity: " + ChatColor.GOLD + "" + ChatColor.BOLD + "✰✰✰";
        else if (rarity == Rarity.FOUR_STARS)
            return ChatColor.WHITE + "Rarity: " + ChatColor.GOLD + "" + ChatColor.BOLD + "✰✰✰✰";
        else if (rarity == Rarity.FIVE_STARS)
            return ChatColor.WHITE + "Rarity: " + ChatColor.GOLD + "" + ChatColor.BOLD + "✰✰✰✰✰";

        return "";
    }

    public static String getRarityColor(Rarity rarity) {
        if (rarity == Rarity.ONE_STAR)
            return ChatColor.WHITE + "" + ChatColor.BOLD;
        else if (rarity == Rarity.TWO_STARS)
            return ChatColor.GREEN + "" + ChatColor.BOLD;
        else if (rarity == Rarity.THREE_STARS)
            return ChatColor.BLUE + "" + ChatColor.BOLD;
        else if (rarity == Rarity.FOUR_STARS)
            return ChatColor.DARK_PURPLE + "" + ChatColor.BOLD;
        else if (rarity == Rarity.FIVE_STARS)
            return ChatColor.GOLD + "" + ChatColor.BOLD;

        return "";
    }
}
