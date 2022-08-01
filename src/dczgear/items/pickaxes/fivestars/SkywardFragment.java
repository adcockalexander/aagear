package dczgear.items.pickaxes.fivestars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SkywardFragment extends GearItem {

    @Override
    public String getName() {
        return "Skyward Fragment";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+50% drops from diamond ore";
        String effect2 = "+50% drops from emerald ore";
        String effect3 = "+50% drops from redstone ore";
        String effect4 = "+50% drops from lapis ore";

        return Arrays.asList(effect, effect2, effect3, effect4);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.AQUA + "" + ChatColor.BOLD + "Skyward Crystallise";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("1.5% chance to 'crystallise' stone when", "broken, creating a diamond or emerald", "ore vein. 10% of ores created this",
                "way will become diamond or emerald blocks.");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("A fragment of a tool dropped from", "the heavens. It has the power", "to re-shape what it touches.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.FIVE_STARS;
    }

    @Override
    public Material getBaseMaterial() {
        return Material.NETHERITE_PICKAXE;
    }

}
