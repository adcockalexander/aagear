package dczgear.items.hoes.threestars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

public class RopeBoundScythe extends GearItem {

    @Override
    public String getName() {
        return "Rope-bound Scythe";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+20% drops from wheat farming";
        String effect2 = "+20% tool XP gain";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.GOLD + "" + ChatColor.BOLD + "Hay Stacker";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("2% chance to drop a hay bale", "when farming wheat.");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("Rope has been loosely tied around this", "scythe. It might fall off at any time.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.THREE_STARS;
    }

}
