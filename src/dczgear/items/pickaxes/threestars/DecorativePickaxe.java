package dczgear.items.pickaxes.threestars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DecorativePickaxe extends GearItem {

    @Override
    public String getName() {
        return "Decorative Pickaxe";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+20% drops from lapis ore";
        String effect2 = "+20% drops from iron ore";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Tacky Decoration";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("5% chance for the pickaxe to lose", "some of its coating when mining ore,", "dropping huge amounts of lapis.");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("Blue gems and lapis lazuli are covering", "this pickaxe. Is it even meant for work?");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.THREE_STARS;
    }

}
