package dczgear.items.pickaxes.twostars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TravellerPickaxe extends GearItem {

    @Override
    public String getName() {
        return "Traveller's Pickaxe";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+10% drops from iron ore";
        String effect2 = "+10% XP from ores";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("A lightweight and well balanced pickaxe", "useful for those on the move.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.TWO_STARS;
    }

}
