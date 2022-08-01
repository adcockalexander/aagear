package dczgear.items.pickaxes.onestar;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SpikyPickaxe extends GearItem {

    @Override
    public String getName() {
        return "Spiky Pickaxe";
    }

    @Override
    public List<String> getEffects() {
        return List.of("+5% drops from iron ore");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("The cheap iron in this pickaxe", "has given it a rough, spiky texture.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.ONE_STAR;
    }

}
