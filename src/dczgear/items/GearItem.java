package dczgear.items;

import dczgear.rarity.Rarity;
import org.bukkit.Material;

import java.util.List;

public abstract class GearItem {

    public abstract String getName();

    public abstract List<String> getEffects();

    public String getSpecialEffectName() {
        return null;
    }

    public List<String> getSpecialEffectDescription() {
        return null;
    }

    public abstract List<String> getDescription();

    public abstract Rarity getRarity();

    public Material getBaseMaterial() {
        return Material.BARRIER;
    }

}
