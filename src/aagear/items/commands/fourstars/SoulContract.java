package aagear.items.commands.fourstars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.Material;

import java.util.List;

public class SoulContract extends GearItem {

    @Override
    public String getName() {
        return "Soul Contract";
    }

    @Override
    public List<String> getEffects() {
        return List.of("Unlocks the ability to keep", "your items on death");
    }

    @Override
    public List<String> getRestrictions() {
        return List.of("May not be used in Mining World");
    }

    @Override
    public List<String> getDescription() {
        return List.of("A contract with the Grim Reaper.", "Sign it, and maybe you'll be", "able to gain his favour.");
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
        return Material.WRITABLE_BOOK;
    }

}
