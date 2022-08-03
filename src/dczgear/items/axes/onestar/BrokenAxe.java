package dczgear.items.axes.onestar;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;

public class BrokenAxe extends GearItem {

    @Override
    public String getName() {
        return "Broken Axe";
    }

    @Override
    public List<String> getEffects() {
        return List.of("+5% drops from melon farming");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("The head of this axe is split in two...", "is it even useful anymore?");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.ONE_STAR;
    }

}
