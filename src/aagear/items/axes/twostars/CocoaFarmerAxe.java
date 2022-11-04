package aagear.items.axes.twostars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;

public class CocoaFarmerAxe extends GearItem {

    @Override
    public String getName() {
        return "Cocoa Farmer's Axe";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+10% drops from cocoa farming";
        String effect2 = "+10% tool XP gain";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("This axe has an extremely sharp edge,", "perfect for splitting open cocoa pods.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.TWO_STARS;
    }

}
