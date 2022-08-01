package dczgear.items.hoes.twostars;

import dczgear.items.GearItem;
import dczgear.rarity.Rarity;

import java.util.Arrays;
import java.util.List;

public class SerratedScythe extends GearItem {

    @Override
    public String getName() {
        return "Serrated Scythe";
    }

    @Override
    public List<String> getEffects() {
        String effect = "+10% drops from sugarcane farming";
        String effect2 = "+10% tool XP gain";

        return Arrays.asList(effect, effect2);
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("The serrated edge of this scythe", "makes it perfect for cutting cane.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.TWO_STARS;
    }

}
