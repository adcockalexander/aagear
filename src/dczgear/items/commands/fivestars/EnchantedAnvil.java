package dczgear.items.commands.fivestars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;
import org.bukkit.Material;

import java.util.List;

public class EnchantedAnvil extends GearItem {

    @Override
    public String getName() {
        return "Enchanted Anvil";
    }

    @Override
    public List<String> getEffects() {
        return List.of("Unlocks /fix all command", "Unlimited use of /fix");
    }

    @Override
    public List<String> getRestrictions() {
        return List.of("Requires 'Portable Anvil'");
    }

    @Override
    public List<String> getDescription() {
        return List.of("An enchanted anvil, with the ability", "to repair thousands of tools", "at once.");
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
        return Material.ENCHANTING_TABLE;
    }

}
