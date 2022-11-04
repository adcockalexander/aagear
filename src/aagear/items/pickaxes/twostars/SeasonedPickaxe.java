package aagear.items.pickaxes.twostars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SeasonedPickaxe extends GearItem {

    @Override
    public String getName() {
        return "Seasoned Pickaxe";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+10% drops from coal ore";
        String effect2 = "+10% XP from ores";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("This pickaxe has been polished by time", "becoming an extension of its owner.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.TWO_STARS;
    }

}
