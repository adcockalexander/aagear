package aagear.items;

import aagear.rarity.Rarity;
import org.bukkit.Material;

import java.util.List;

/**
 * The AAGear representation of a custom gear item.
 * Must be converted to a physical Minecraft item using ItemCreator
 * in order to be used by a player.
 */
public abstract class GearItem {

    public abstract String getName();

    public abstract List<String> getEffects();

    public List<String> getRestrictions() {
        return null;
    }

    public String getSpecialEffectName() {
        return null;
    }

    public List<String> getSpecialEffectDescription() {
        return null;
    }

    public abstract List<String> getDescription();

    public abstract Rarity getRarity();

    public boolean hasLevel() {
        return true;
    }

    public Material getBaseMaterial() {
        return Material.BARRIER;
    }

}
