package aagear.items.pickaxes.fourstars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class MasterPride extends GearItem {

    @Override
    public String getName() {
        return "Master's Pride";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+35% XP from ores";
        String effect2 = "+35% tool XP gain";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Experienced";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("Randomly creates huge amounts of EXP", "bottles when breaking stone (1%",
                "chance) or ores (5% chance).");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("The carefully maintained pickaxe of", "a master miner. It shines as if", "it were still brand new.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.FOUR_STARS;
    }

    @Override
    public Material getBaseMaterial() {
        return Material.NETHERITE_PICKAXE;
    }

}
