package dczgear.items.pickaxes.threestars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GildedPickaxe extends GearItem {

    @Override
    public String getName() {
        return "Gilded Pickaxe";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+20% drops from gold ore";
        String effect2 = "+20% drops from iron ore";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.GOLD + "" + ChatColor.BOLD + "Midas Touch";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("1% chance to convert Stone", "to Gold Blocks when broken");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("Flecks of gold have been integrated", "into this pick, making it sparkle and shine.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.THREE_STARS;
    }

}
