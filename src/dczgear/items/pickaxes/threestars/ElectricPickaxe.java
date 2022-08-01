package dczgear.items.pickaxes.threestars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ElectricPickaxe extends GearItem {

    @Override
    public String getName() {
        return "Electric Pickaxe";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+20% drops from redstone ore";
        String effect2 = "+20% drops from iron ore";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Electro-charged";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("5% chance to shock ore veins,", "dropping huge amounts of redstone");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("Redstone dust has given this pickaxe", "the ability to shock what it touches.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.THREE_STARS;
    }

}
