package dczgear.items.commands.fivestars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;
import org.bukkit.Material;

import java.util.List;

public class AdvancedHomingMarker extends GearItem {

    @Override
    public String getName() {
        return "Advanced Homing Marker";
    }

    @Override
    public List<String> getEffects() {
        return List.of("Unlocks the ability to set up to", "50 homes using /sethome <name>");
    }

    @Override
    public List<String> getRestrictions() {
        return List.of("Requires 'Homing Marker'");
    }

    @Override
    public List<String> getDescription() {
        return List.of("A more advanced homing marker that", "shines through the night, providing", "a perfect waypoint to follow.");
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
        return Material.SOUL_TORCH;
    }

}
