package aagear.items.axes.onestar;

import aagear.items.GearItem;
import aagear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;

public class OrangeAxe extends GearItem {

    @Override
    public String getName() {
        return "Orange Axe";
    }

    @Override
    public List<String> getEffects() {
        return List.of("+5% drops from pumpkin farming");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("This axe has been stained orange", "by pumpkins over time.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.ONE_STAR;
    }

}
