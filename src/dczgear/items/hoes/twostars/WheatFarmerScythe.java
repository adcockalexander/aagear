package dczgear.items.hoes.twostars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;

public class WheatFarmerScythe extends GearItem {

    @Override
    public String getName() {
        return "Wheat Farmer's Scythe";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+10% drops from wheat farming";
        String effect2 = "+10% tool XP gain";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("A scythe used by an old wheat", "farmer. It's been kept very clean.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.TWO_STARS;
    }

}
