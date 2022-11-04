package aagear.items.commands.fourstars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.Material;

import java.util.List;

public class HomingMarker extends GearItem {

    @Override
    public String getName() {
        return "Homing Marker";
    }

    @Override
    public List<String> getEffects() {
        return List.of("Unlocks the ability to set up to", "5 homes using /sethome <name>");
    }

    @Override
    public List<String> getDescription() {
        return List.of("A basic homing marker that allows", "adventurers to easily find places", "they've visited in the past.");
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
        return Material.REDSTONE_TORCH;
    }

}
