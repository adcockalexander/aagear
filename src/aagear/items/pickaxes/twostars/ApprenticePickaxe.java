package aagear.items.pickaxes.twostars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;

public class ApprenticePickaxe extends GearItem {

    @Override
    public String getName() {
        return "Apprentice's Pickaxe";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+10% XP from ores";
        String effect2 = "+10% tool XP gain";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("A pickaxe given to a miner's apprentice.", "It's perfect for learning the trade.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.TWO_STARS;
    }

}
