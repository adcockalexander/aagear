package aagear.items.pickaxes.onestar;

import aagear.items.GearItem;
import aagear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RookiePickaxe extends GearItem {

    @Override
    public String getName() {
        return "Rookie's Pickaxe";
    }

    @Override
    public List<String> getEffects() {
        return List.of("+5% XP from ores");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("A pickaxe made by a rookie, with", "basic build quality. It'll do for now!");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.ONE_STAR;
    }

}
