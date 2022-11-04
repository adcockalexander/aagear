package aagear.items.axes.fourstars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class CocoaSpreader extends GearItem {

    @Override
    public String getName() {
        return "Cocoa Spreader";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+35% drops from cocoa farming";
        String effect2 = "+35% tool XP gain";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Cocoa Replant";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("Automatically replants cocoa when broken,", "using cocoa from the inventory.");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("This axe has a fan attached to it,", "spreading out some cocoa each time",
                "you break a pod.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.FOUR_STARS;
    }

    @Override
    public Material getBaseMaterial() { return Material.NETHERITE_AXE; }
}
