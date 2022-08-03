package dczgear.items.axes.twostars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;

public class SplittingAxe extends GearItem {

    @Override
    public String getName() {
        return "Splitting Axe";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+10% drops from melon farming";
        String effect2 = "+10% drops from pumpkin farming";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("This axe has a split edge, allowing it", "to cleave melons and pumpkins with ease.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.TWO_STARS;
    }

}
