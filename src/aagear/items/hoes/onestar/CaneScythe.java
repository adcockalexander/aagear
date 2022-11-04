package aagear.items.hoes.onestar;

import aagear.items.GearItem;
import aagear.rarity.Rarity;

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
