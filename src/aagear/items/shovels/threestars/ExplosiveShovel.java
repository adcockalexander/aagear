package aagear.items.shovels.threestars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

public class ExplosiveShovel extends GearItem {

    @Override
    public String getName() {
        return "Explosive Shovel";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+20% random drops from dirt";
        String effect2 = "+20% tool XP gain";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.RED + "" + ChatColor.BOLD + "Detonate";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("10% chance to cause an explosion, destroying", "dirt, sand or gravel in a 3x3 area.");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("A shovel imbued with explosion magic!", "It's useful for clearing space out.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.THREE_STARS;
    }

}
