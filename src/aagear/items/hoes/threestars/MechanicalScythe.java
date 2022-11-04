package aagear.items.hoes.threestars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

public class MechanicalScythe extends GearItem {

    @Override
    public String getName() {
        return "Mechanical Scythe";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+20% drops from sugarcane farming";
        String effect2 = "+20% tool XP gain";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.YELLOW + "" + ChatColor.BOLD + "Cane Refiner";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("Refines sugarcane when farmed, automatically", "converting sugarcane into sugar.");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("Mechanical parts have been attached to this", "scythe, giving it the ability to refine cane.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.THREE_STARS;
    }

}
