package dczgear.items.axes.onestar;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;

public class BrownAxe extends GearItem {

    @Override
    public String getName() {
        return "Brown Axe";
    }

    @Override
    public List<String> getEffects() {
        return List.of("+5% drops from cocoa farming");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("This axe has been stained brown", "by cocoa beans over time.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.ONE_STAR;
    }

}
