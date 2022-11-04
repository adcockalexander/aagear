package aagear.items.hoes.onestar;

import aagear.items.GearItem;
import aagear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;

public class GrassScythe extends GearItem {

    @Override
    public String getName() {
        return "Grass Scythe";
    }

    @Override
    public List<String> getEffects() {
        return List.of("+5% drops from wheat farming");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("A simple scythe, perfect for", "cutting tall grass and wheat.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.ONE_STAR;
    }

}
