package aagear.items.commands.fourstars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.Material;

import java.util.List;

public class ShapeshiftingHat extends GearItem {

    @Override
    public String getName() {
        return "Shapeshifting Hat";
    }

    @Override
    public List<String> getEffects() {
        return List.of("Unlocks /hat command");
    }

    @Override
    public List<String> getDescription() {
        return List.of("A hat that is able to shape-shift", "into any object. How strange!");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.FOUR_STARS;
    }

    @Override
    public boolean hasLevel() {
        return false;
    }

    @Override
    public Material getBaseMaterial() {
        return Material.LEATHER_HELMET;
    }

}
