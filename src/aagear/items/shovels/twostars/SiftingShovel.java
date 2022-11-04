package aagear.items.shovels.twostars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;

public class SiftingShovel extends GearItem {

    @Override
    public String getName() {
        return "Sifting Shovel";
    }

    @Override
    public List<String> getEffects() {
        return List.of("+10% random drops from sand & gravel");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("This shovel has an attachment which", "automatically sifts through dust.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.TWO_STARS;
    }

}
