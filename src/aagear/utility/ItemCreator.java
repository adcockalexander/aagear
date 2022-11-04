package aagear.utility;

import aagear.items.GearItem;
import aagear.rarity.RarityMapper;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemCreator {

    // Creates an ItemStack (a real Minecraft item) from a GearItem (the AAGear representation).
    public static ItemStack createItemFromGear(GearItem gear, Material mat) {
        ItemStack item = new ItemStack(mat);
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(RarityMapper.getRarityColor(gear.getRarity()) + gear.getName());

        List<String> lore = new ArrayList<>();

        lore.add(RarityMapper.getRarityLine(gear.getRarity()));

        if (gear.hasLevel()) {
            lore.add(LevelParser.getLevel0String());
        }

        lore.add("");

        for (String effect : gear.getEffects()) {
            lore.add(org.bukkit.ChatColor.GREEN + effect);
        }

        if (gear.getSpecialEffectName() != null) {
            lore.add(gear.getSpecialEffectName());

            for (String descLine : gear.getSpecialEffectDescription()) {
                lore.add(org.bukkit.ChatColor.WHITE + descLine);
            }
        }

        lore.add("");

        if (gear.getRestrictions() != null) {
            for (String restriction : gear.getRestrictions()) {
                lore.add(ChatColor.RED + restriction);
            }
            lore.add("");
        }

        for (String descLine : gear.getDescription()) {
            lore.add(org.bukkit.ChatColor.GRAY + "" + org.bukkit.ChatColor.ITALIC + descLine);
        }

        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);

        return item;
    }

    /** Modifies a given ItemStack based on a GearItem.
     * This is roughly equivalent to deleting the ItemStack and then using createItemFromGear,
     * but it's faster and doesn't cause any weird hiccups in the player experience.
     */
    public static void modifyItemFromGear(GearItem gear, ItemStack item) {
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(RarityMapper.getRarityColor(gear.getRarity()) + gear.getName());

        List<String> lore = new ArrayList<>();

        lore.add(RarityMapper.getRarityLine(gear.getRarity()));

        lore.add(LevelParser.getLevel0String());

        lore.add("");

        for (String effect : gear.getEffects()) {
            lore.add(ChatColor.GREEN + effect);
        }

        if (gear.getSpecialEffectName() != null) {
            lore.add(gear.getSpecialEffectName());

            for (String descLine : gear.getSpecialEffectDescription()) {
                lore.add(ChatColor.WHITE + descLine);
            }
        }

        lore.add("");

        for (String descLine : gear.getDescription()) {
            lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + descLine);
        }

        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
    }
}
