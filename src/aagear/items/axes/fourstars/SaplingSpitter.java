package aagear.items.axes.fourstars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class SaplingSpitter extends GearItem {

    @Override
    public String getName() {
        return "Sapling Spitter";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+35% drops from tree farming";
        String effect2 = "+35% tool XP gain";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Tree Replant";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("Automatically replants trees when broken,", "using saplings from the inventory.");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("This axe has a mouth on it! It spits", "out saplings whenever you chop a",
                "tree down. How useful!");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.FOUR_STARS;
    }

    @Override
    public Material getBaseMaterial() { return Material.NETHERITE_AXE; }
}
