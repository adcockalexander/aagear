package aagear.items.hoes.onestar;

import aagear.items.GearItem;
import aagear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;

public class PurpleScythe extends GearItem {

    @Override
    public String getName() {
        return "Purple Scythe";
    }

    @Override
    public List<String> getEffects() {
        return List.of("+5% drops from beetroot farming");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("The blade of this scythe has", "been stained purple over time.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.ONE_STAR;
    }

}
