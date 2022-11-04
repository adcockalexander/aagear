package aagear.items.commands.fivestars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.Material;

import java.util.List;

public class FlightCatalyst extends GearItem {

    @Override
    public String getName() {
        return "Flight Catalyst";
    }

    @Override
    public List<String> getEffects() {
        return List.of("Unlocks /fly command");
    }

    @Override
    public List<String> getRestrictions() {
        return List.of("May not be used in Mining World");
    }

    @Override
    public List<String> getDescription() {
        return List.of("The feather of a long-lost magical", "bird. It's said that it can", "grant the power of flight.");
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
        return Material.FEATHER;
    }

}
