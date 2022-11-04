package dczgear.items.shovels.onestar;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;

public class DirtyShovel extends GearItem {

    @Override
    public String getName() {
        return "Dirty Shovel";
    }

    @Override
    public List<String> getEffects() {
        return List.of("+5% random drops from dirt");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("This shovel is covered in dirt", "and mud. How unsanitary!");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.ONE_STAR;
    }

}
