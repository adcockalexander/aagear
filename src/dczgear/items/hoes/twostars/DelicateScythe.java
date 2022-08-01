package dczgear.items.hoes.twostars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;

public class DelicateScythe extends GearItem {

    @Override
    public String getName() {
        return "Serrated Scythe";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+10% drops from carrot farming";
        String effect2 = "+10% drops from beetroot farming";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("This light-weight scythe is perfect for", "extracting delicate crops from the ground.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.TWO_STARS;
    }

}
