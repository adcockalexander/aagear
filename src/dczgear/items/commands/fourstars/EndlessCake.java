package dczgear.items.commands.fourstars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;
import org.bukkit.Material;

import java.util.List;

public class EndlessCake extends GearItem {

    @Override
    public String getName() {
        return "Endless Cake";
    }

    @Override
    public List<String> getEffects() {
        return List.of("Unlocks /feed command", "Unlocks /heal command");
    }

    @Override
    public List<String> getRestrictions() {
        return List.of("May not be used in Mining World");
    }

    @Override
    public List<String> getDescription() {
        return List.of("A cake with weird properties. When you", "eat some of it, it will re-appear", "the next day!");
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
        return Material.CAKE;
    }

}
