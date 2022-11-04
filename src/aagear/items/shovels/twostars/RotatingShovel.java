package aagear.items.shovels.twostars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;

public class RotatingShovel extends GearItem {

    @Override
    public String getName() {
        return "Rotating Shovel";
    }

    @Override
    public List<String> getEffects() {
        return List.of("+10% random drops from dirt");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("The end of this shovel constantly", "rotates like a drill head.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.TWO_STARS;
    }

}
