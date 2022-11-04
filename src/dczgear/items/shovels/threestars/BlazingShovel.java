package dczgear.items.shovels.threestars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

public class BlazingShovel extends GearItem {

    @Override
    public String getName() {
        return "Blazing Shovel";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+20% random drops from sand & gravel";
        String effect2 = "+20% tool XP gain";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.DARK_RED + "" + ChatColor.BOLD + "Melt";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("Converts sand into glass. Can be disabled", "by holding a water bucket off-hand.");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("The head of this shovel burns brightly.", "It can melt whatever it touches.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.THREE_STARS;
    }

}
