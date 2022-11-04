package aagear.items.shovels.onestar;

import aagear.items.GearItem;
import aagear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;

public class SteelShovel extends GearItem {

    @Override
    public String getName() {
        return "Steel Shovel";
    }

    @Override
    public List<String> getEffects() {
        return List.of("+5% random drops from sand & gravel");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("This shovel is made of pure", "steel, making it very durable.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.ONE_STAR;
    }

}
