package aagear.items.commands.fourstars;

import aagear.items.GearItem;
import aagear.rarity.Rarity;
import org.bukkit.Material;

import java.util.List;

public class MiniatureBlackhole extends GearItem {

    @Override
    public String getName() {
        return "Miniature Blackhole";
    }

    @Override
    public List<String> getEffects() {
        return List.of("Unlocks /condense command - combines", "items into more compact blocks");
    }

    @Override
    public List<String> getDescription() {
        return List.of("A pocket-sized blackhole! You can", "use this to condense everything", "into a smaller form.");
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
        return Material.POLISHED_BLACKSTONE_BUTTON;
    }

}
