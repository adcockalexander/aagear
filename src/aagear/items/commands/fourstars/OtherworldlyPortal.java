package aagear.items.commands.fourstars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.Material;

import java.util.List;

public class OtherworldlyPortal extends GearItem {

    @Override
    public String getName() {
        return "Otherworldly Portal";
    }

    @Override
    public List<String> getEffects() {
        return List.of("Unlocks /warp command");
    }

    @Override
    public List<String> getDescription() {
        return List.of("A door from another world that", "can be placed down to create", "a portal to anywhere.");
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
        return Material.WARPED_DOOR;
    }

}
