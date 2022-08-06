package dczgear.items.commands.fivestars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;
import org.bukkit.Material;

import java.util.List;

public class SpeedCatalyst extends GearItem {

    @Override
    public String getName() {
        return "Speed Catalyst";
    }

    @Override
    public List<String> getEffects() {
        return List.of("Unlocks /speed command");
    }

    @Override
    public List<String> getRestrictions() {
        return List.of("May not be used in Mining World");
    }

    @Override
    public List<String> getDescription() {
        return List.of("The golden boots used by a", "trickster God. They can grant", "the power of swiftness.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.FIVE_STARS;
    }

    @Override
    public boolean hasLevel() {
        return false;
    }

    @Override
    public Material getBaseMaterial() {
        return Material.GOLDEN_BOOTS;
    }

}
