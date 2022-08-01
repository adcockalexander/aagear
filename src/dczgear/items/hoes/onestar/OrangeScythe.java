package dczgear.items.hoes.onestar;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;

public class OrangeScythe extends GearItem {

    @Override
    public String getName() {
        return "Orange Scythe";
    }

    @Override
    public List<String> getEffects() {
        return List.of("+5% drops from carrot farming");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("The blade of this scythe has", "been stained orange over time.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.ONE_STAR;
    }

}
