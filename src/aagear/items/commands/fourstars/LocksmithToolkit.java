package aagear.items.commands.fourstars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.Material;

import java.util.List;

public class LocksmithToolkit extends GearItem {

    @Override
    public String getName() {
        return "Locksmith's Toolkit";
    }

    @Override
    public List<String> getEffects() {
        return List.of("Unlocks unlimited LWCs", "(type /lwc for info)");
    }

    @Override
    public List<String> getDescription() {
        return List.of("A useful toolkit belonging to", "a master locksmith. You can lock", "and unlock anything with this!");
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
        return Material.CHEST;
    }

}
