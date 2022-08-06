package dczgear.items.commands.fourstars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;
import org.bukkit.Material;

import java.util.List;

public class SaplingOfKnowledge extends GearItem {

    @Override
    public String getName() {
        return "Sapling of Knowledge";
    }

    @Override
    public List<String> getEffects() {
        return List.of("Unlocks x2 mcMMO xp", "(type /mcstats to see skills)");
    }

    @Override
    public List<String> getDescription() {
        return List.of("A sapling cut from a tree that has", "lived for eons. It contains the", "knowledge of that same tree.");
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
        return Material.OAK_SAPLING;
    }

}
