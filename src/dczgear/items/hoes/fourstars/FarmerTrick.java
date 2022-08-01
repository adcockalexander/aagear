package dczgear.items.hoes.fourstars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class FarmerTrick extends GearItem {

    @Override
    public String getName() {
        return "Farmer's Trick";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+35% drops from carrot farming";
        String effect2 = "+35% drops from beetroot farming";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Auto Replant";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("Automatically replants crops when broken,", "using seeds from the inventory.");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("A crafty farmer has attached a bag", "of seeds and a tube to this scythe,",
                "so it replants as you go along.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.FOUR_STARS;
    }

    @Override
    public Material getBaseMaterial() { return Material.NETHERITE_HOE; }

}
