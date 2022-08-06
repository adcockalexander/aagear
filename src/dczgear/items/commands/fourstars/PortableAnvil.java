package dczgear.items.commands.fourstars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;
import org.bukkit.Material;

import java.util.List;

public class PortableAnvil extends GearItem {

    @Override
    public String getName() {
        return "Portable Anvil";
    }

    @Override
    public List<String> getEffects() {
        return List.of("Unlocks /fix command", "(1 item per hour)");
    }

    @Override
    public List<String> getDescription() {
        return List.of("A miniature portable anvil, perfect", "for repairing tools on the go.");
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
        return Material.ANVIL;
    }

}
