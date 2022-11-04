package aagear.listeners.hoes;

import aagear.items.GearItem;
import aagear.items.hoes.onestar.*;
import aagear.items.hoes.twostars.*;
import aagear.items.hoes.threestars.*;
import aagear.utility.ItemCreator;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HoeCraftListener implements Listener {

    private static final List<GearItem> oneStars = Arrays.asList(new CaneScythe(), new GrassScythe(), new OrangeScythe(), new PurpleScythe());
    private static final List<GearItem> twoStars = Arrays.asList(new DelicateScythe(), new SerratedScythe(), new WheatFarmerScythe());
    private static final List<GearItem> threeStars = Arrays.asList(new EnchantedScythe(), new MechanicalScythe(), new RopeBoundScythe());

    @EventHandler
    public static void onInventoryClick(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();

        if (item == null) return;

        ItemMeta itemMeta = item.getItemMeta();

        if (itemMeta == null || itemMeta.hasLore()) return;

        Random rng = new Random();

        GearItem chosen;

        if (item.getType() == Material.WOODEN_HOE) {
            chosen = oneStars.get(rng.nextInt(oneStars.size()));
        } else if (item.getType() == Material.STONE_HOE) {
            chosen = oneStars.get(rng.nextInt(oneStars.size()));
        } else if (item.getType() == Material.IRON_HOE) {
            int roll = rng.nextInt(10);

            if (roll < 2) { // 20% for 2-star
                chosen = twoStars.get(rng.nextInt(twoStars.size()));
            } else {
                chosen = oneStars.get(rng.nextInt(oneStars.size()));
            }
        } else if (item.getType() == Material.GOLDEN_HOE) {
            int roll = rng.nextInt(10);

            if (roll < 2) { // 20% for 2-star
                chosen = twoStars.get(rng.nextInt(twoStars.size()));
            } else {
                chosen = oneStars.get(rng.nextInt(oneStars.size()));
            }
        } else if (item.getType() == Material.DIAMOND_HOE) {
            int roll = rng.nextInt(10);

            if (roll < 1) { // 10% for 3-star
                chosen = threeStars.get(rng.nextInt(threeStars.size()));
            } else if (roll < 5) { // 40% for 2-star
                chosen = twoStars.get(rng.nextInt(twoStars.size()));
            } else {
                chosen = oneStars.get(rng.nextInt(oneStars.size()));
            }
        } else if (item.getType() == Material.NETHERITE_HOE) {
            int roll = rng.nextInt(10);

            if (roll < 2) { // 20% for 3-star
                chosen = threeStars.get(rng.nextInt(threeStars.size()));
            } else {
                chosen = twoStars.get(rng.nextInt(twoStars.size()));
            }
        } else {
            return;
        }

        ItemCreator.modifyItemFromGear(chosen, item);
    }
}
