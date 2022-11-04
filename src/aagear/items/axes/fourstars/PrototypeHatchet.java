package aagear.items.axes.fourstars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class PrototypeHatchet extends GearItem {

    @Override
    public String getName() {
        return "Prototype Hatchet";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+35% drops from melon farming";
        String effect2 = "+35% drops from pumpkin farming";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.RED + "" + ChatColor.BOLD + "Crop Shatter";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("10% chance to 'shatter' melons or pumpkins,", "breaking extra crops within a 1 block",
            "distance and doubling their drops.");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("A prototype made years ago by a mysterious", "research company. It strikes with twice",
                "the strength of its user.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.FOUR_STARS;
    }

    @Override
    public Material getBaseMaterial() { return Material.NETHERITE_AXE; }
}
