package aagear.items.axes.fivestars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class EarthBlessing extends GearItem {

    @Override
    public String getName() {
        return "Earth's Blessing";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+50% drops from melon farming";
        String effect2 = "+50% drops from pumpkin farming";
        String effect3 = "+50% tool XP gain";
        String effect4 = "+50% chance to gain XP when farming";

        return Arrays.asList(effect, effect2, effect3, effect4);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.GOLD + "" + ChatColor.BOLD + "Mega Shatter";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("15% chance to 'shatter' melons or pumpkins,", "breaking extra crops within a 2 block",
                "distance and doubling their drops.");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("Terra, the Earth God, has blessed this", "axe with the power to harvest",
                "entire farms at once.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.FIVE_STARS;
    }

    @Override
    public Material getBaseMaterial() { return Material.NETHERITE_AXE; }
}
