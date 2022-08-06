package dczgear.items.commands.fourstars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;
import org.bukkit.Material;

import java.util.List;

public class ExperienceBinder extends GearItem {

    @Override
    public String getName() {
        return "Experience Binder";
    }

    @Override
    public List<String> getEffects() {
        return List.of("Unlocks the ability to keep", "all XP on death");
    }

    @Override
    public List<String> getDescription() {
        return List.of("This book contains a spell that", "gives adventurer's the ability to", "pass knowledge to another life.");
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
        return Material.ENCHANTED_BOOK;
    }

}
