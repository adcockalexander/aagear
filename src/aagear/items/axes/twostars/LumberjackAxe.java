package aagear.items.axes.twostars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;

public class LumberjackAxe extends GearItem {

    @Override
    public String getName() {
        return "Lumberjack's Axe";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+10% drops from tree farming";
        String effect2 = "+10% tool XP gain";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("This axe has a lumberjack's shirt", "tied around the handle for grip.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.TWO_STARS;
    }

}
