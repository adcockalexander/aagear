package dczgear.items.axes.onestar;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;

public class SteelAxe extends GearItem {

    @Override
    public String getName() {
        return "Steel Axe";
    }

    @Override
    public List<String> getEffects() {
        return List.of("+5% drops from tree farming");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("The steel head of this axe", "is perfect for cutting logs.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.ONE_STAR;
    }

}
