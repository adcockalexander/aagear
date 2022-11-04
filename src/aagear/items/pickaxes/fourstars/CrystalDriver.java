package aagear.items.pickaxes.fourstars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CrystalDriver extends GearItem {

    @Override
    public String getName() {
        return "Crystal Driver";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+35% drops from diamond ore";
        String effect2 = "+35% drops from emerald ore";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.AQUA + "" + ChatColor.BOLD + "Crystallise";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("1% chance to 'crystallise' stone when", "broken, creating a diamond or emerald", "ore vein.");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("A pickaxe of pure crystal, rumoured", "to have been created by an", "ancient elven civilisation.");
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
