package dczgear.items.pickaxes.fivestars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class DragonTooth extends GearItem {

    @Override
    public String getName() {
        return "Dragon's Tooth";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+50% drops from redstone ore";
        String effect2 = "+50% drops from lapis ore";
        String effect3 = "+50% XP from ores";
        String effect4 = "+50% tool XP gain";

        return Arrays.asList(effect, effect2, effect3, effect4);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.DARK_RED + "" + ChatColor.BOLD + "Dragon Transfusion";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("5% chance to tranfuse redstone and lapis", "ore when broken, randomly converting all",
                "drops into diamonds (20% chance), emeralds",
                "(20% chance), or gold (60% chance).");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("A shard of a tooth from an", "almighty dragon. The magic of an", "ancient being dwells within.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.FIVE_STARS;
    }

    @Override
    public Material getBaseMaterial() {
        return Material.NETHERITE_PICKAXE;
    }

}
