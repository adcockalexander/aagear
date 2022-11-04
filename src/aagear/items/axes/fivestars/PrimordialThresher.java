package aagear.items.axes.fivestars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class PrimordialThresher extends GearItem {

    @Override
    public String getName() {
        return "Primordial Thresher";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+50% drops from cocoa farming";
        String effect2 = "+50% drops from tree farming";
        String effect3 = "+50% tool XP gain";
        String effect4 = "+50% chance to gain XP when farming";

        return Arrays.asList(effect, effect2, effect3, effect4);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Mega Replant";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("Automatically replants cocoa & trees when broken.", "No cocoa or saplings are required for this effect.");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("A farming tool gifted to the people", "by the ancient gods of old. It can",
                "create life from thin air.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.FIVE_STARS;
    }

    @Override
    public Material getBaseMaterial() { return Material.NETHERITE_AXE; }
}
