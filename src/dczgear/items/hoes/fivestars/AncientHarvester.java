package dczgear.items.hoes.fivestars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class AncientHarvester extends GearItem {

    @Override
    public String getName() {
        return "Ancient Harvester";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+50% drops from wheat farming";
        String effect2 = "+50% drops from carrot farming";
        String effect3 = "+50% drops from beetroot farming";
        String effect4 = "+50% drops from sugarcane farming";

        return Arrays.asList(effect, effect2, effect3, effect4);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Mega Replant";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("Automatically replants crops when broken.", "No seeds are required for this effect.");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("This ancient tool was used by", "civilisations long ago, helping to",
                "provide food for their people.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.FIVE_STARS;
    }

    @Override
    public Material getBaseMaterial() { return Material.NETHERITE_HOE; }

}
