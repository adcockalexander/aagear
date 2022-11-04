package aagear.items.axes.threestars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

public class ChocolateAxe extends GearItem {

    @Override
    public String getName() {
        return "Chocolate Axe";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+20% drops from cocoa farming";
        String effect2 = "+20% tool XP gain";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.DARK_RED + "" + ChatColor.BOLD + "Sweet Tooth";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("2% chance to drop a huge amount of", "cookies when farming cocoa beans.");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("This axe is made of...chocolate? Somehow, it", "still works as good as a metal one.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.THREE_STARS;
    }

}
