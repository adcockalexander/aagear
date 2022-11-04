package aagear.items.pickaxes.fourstars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VolcanicShard extends GearItem {

    @Override
    public String getName() {
        return "Volcanic Shard";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+35% drops from redstone ore";
        String effect2 = "+35% drops from lapis ore";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public String getSpecialEffectName() {
        return ChatColor.RED + "" + ChatColor.BOLD + "Latent Heat";
    }

    @Override
    public List<String> getSpecialEffectDescription() {
        return Arrays.asList("Automatically smelts iron and gold", "ore when broken, producing", "2 ingots each time.");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("A shard pulled from the depths of", "a volcano. Magma is inside the core,", "making it warm to the touch.");
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
