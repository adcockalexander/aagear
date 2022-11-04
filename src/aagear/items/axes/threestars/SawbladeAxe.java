package aagear.items.axes.threestars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

public class SawbladeAxe extends GearItem {

    @Override
    public String getName() {
        return "Sawblade Axe";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+20% drops from tree farming";
        String effect2 = "+20% tool XP gain";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Tree Splitter";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("20% chance to split logs into two,", "doubling their drops.");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("The head of this axe has been converted", "into a rotating sawblade! Don't touch it...");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.THREE_STARS;
    }

}
