package aagear.items.axes.threestars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

public class EnchantedAxe extends GearItem {

    @Override
    public String getName() {
        return "Enchanted Axe";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+20% drops from melon farming";
        String effect2 = "+20% drops from pumpkin farming";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.GREEN + "" + ChatColor.BOLD + "Farming Haul";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("2% chance to drop a huge amount of extra", "crops when farming melons or pumpkins.");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("This axe has been enchanted by a", "fairy who took a liking to farming.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.THREE_STARS;
    }

}
