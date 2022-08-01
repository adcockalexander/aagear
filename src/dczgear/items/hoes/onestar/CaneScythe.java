package dczgear.items.hoes.onestar;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;

public class CaneScythe extends GearItem {

    @Override
    public String getName() {
        return "Cane Scythe";
    }

    @Override
    public List<String> getEffects() {
        return List.of("+5% drops from sugarcane farming");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("The sharpened blade of this scythe", "is perfect for cutting cane.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.ONE_STAR;
    }

}
