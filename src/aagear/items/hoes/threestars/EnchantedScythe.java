package aagear.items.hoes.threestars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

public class EnchantedScythe extends GearItem {

    @Override
    public String getName() {
        return "Enchanted Scythe";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+20% drops from carrot farming";
        String effect2 = "+20% drops from beetroot farming";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.GREEN + "" + ChatColor.BOLD + "Green Fingers";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("2% chance to drop a huge amount of extra", "crops when farming beetroot or carrot.");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("This scythe has been enchanted by a", "fairy who took a liking to gardening.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.THREE_STARS;
    }

}
