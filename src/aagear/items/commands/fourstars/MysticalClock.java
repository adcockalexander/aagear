package aagear.items.commands.fourstars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.Material;

import java.util.List;

public class MysticalClock extends GearItem {

    @Override
    public String getName() {
        return "Mystical Clock";
    }

    @Override
    public List<String> getEffects() {
        return List.of("Unlocks /ptime command - sets", "time of day for yourself");
    }

    @Override
    public List<String> getDescription() {
        return List.of("An enchanted clock previously owned", "by a witch. It can manipulate", "the position of the sun.");
    }

    @Override
    public Rarity getRarity() {
        return Rarity.FOUR_STARS;
    }

    @Override
    public boolean hasLevel() {
        return false;
    }

    @Override
    public Material getBaseMaterial() {
        return Material.CLOCK;
    }

}
