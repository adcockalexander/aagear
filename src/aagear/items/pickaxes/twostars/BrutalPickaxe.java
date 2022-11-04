package aagear.items.pickaxes.twostars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BrutalPickaxe extends GearItem {

    @Override
    public String getName() {
        return "Brutal Pickaxe";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+10% drops from coal ore";
        String effect2 = "+10% drops from iron ore";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("Years of use has made this tool harden", "like netherite, cracking rocks like glass.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.TWO_STARS;
    }

}
