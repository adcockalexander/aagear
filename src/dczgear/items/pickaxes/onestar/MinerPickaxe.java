package dczgear.items.pickaxes.onestar;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MinerPickaxe extends GearItem {

    @Override
    public String getName() {
        return "Miner's Pickaxe";
    }

    @Override
    public List<String> getEffects() {
        return List.of("+5% drops from coal ore");
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("Slicked with coal dust, this pickaxe", "has clearly seen a lot of work.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.ONE_STAR;
    }

}
