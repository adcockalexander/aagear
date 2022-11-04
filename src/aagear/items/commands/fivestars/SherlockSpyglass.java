package aagear.items.commands.fivestars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.Material;

import java.util.List;

public class SherlockSpyglass extends GearItem {

    @Override
    public String getName() {
        return "Sherlock's Spyglass";
    }

    @Override
    public List<String> getEffects() {
        return List.of("Unlocks /vanish command", "Unlocks /co inspect command");
    }

    @Override
    public List<String> getRestrictions() {
        return List.of("/vanish may not be used in Mining World");
    }

    @Override
    public List<String> getDescription() {
        return List.of("An old spyglass owned by...Sherlock", "Holmes? Maybe with this, you can", "become an undercover detective too.");
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
        return Material.SPYGLASS;
    }

}
