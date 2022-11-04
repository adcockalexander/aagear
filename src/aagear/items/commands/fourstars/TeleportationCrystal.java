package aagear.items.commands.fourstars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.Material;

import java.util.List;

public class TeleportationCrystal extends GearItem {

    @Override
    public String getName() {
        return "Teleportation Crystal";
    }

    @Override
    public List<String> getEffects() {
        return List.of("Unlocks /tpa command", "Unlocks /tpahere command");
    }

    @Override
    public List<String> getDescription() {
        return List.of("This crystal contains the power to", "teleport the user to any other", "being of their choice.");
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
        return Material.END_CRYSTAL;
    }

}
