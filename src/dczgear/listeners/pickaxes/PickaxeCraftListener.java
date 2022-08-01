package dczgear.listeners.pickaxes;

import dczgear.items.GearItem;
import dczgear.items.pickaxes.onestar.*;
import dczgear.items.pickaxes.twostars.*;
import dczgear.items.pickaxes.threestars.*;

import dczgear.utility.ItemCreator;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Arrays;
import java.util.Random;

public class PickaxeCraftListener implements Listener {

    private static final List<GearItem> oneStars = Arrays.asList(new MinerPickaxe(), new RookiePickaxe(), new SpikyPickaxe());
    private static final List<GearItem> twoStars = Arrays.asList(new BrutalPickaxe(), new SeasonedPickaxe(),
            new TravellerPickaxe(), new ApprenticePickaxe());
    private static final List<GearItem> threeStars = Arrays.asList(new DecorativePickaxe(), new ElectricPickaxe(), new GildedPickaxe());

    @EventHandler
    public static void onInventoryClick(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();

        if (item == null) return;

        ItemMeta itemMeta = item.getItemMeta();

        if (itemMeta == null || itemMeta.hasLore()) return;

        Random rng = new Random();

        GearItem chosen;

        if (item.getType() == Material.WOODEN_PICKAXE) {
            chosen = oneStars.get(rng.nextInt(oneStars.size()));
        } else if (item.getType() == Material.STONE_PICKAXE) {
            chosen = oneStars.get(rng.nextInt(oneStars.size()));
        } else if (item.getType() == Material.IRON_PICKAXE) {
            int roll = rng.nextInt(10);

            if (roll < 2) { // 20% for 2-star
                chosen = twoStars.get(rng.nextInt(twoStars.size()));
            } else {
                chosen = oneStars.get(rng.nextInt(oneStars.size()));
            }
        } else if (item.getType() == Material.GOLDEN_PICKAXE) {
            int roll = rng.nextInt(10);

            if (roll < 2) { // 20% for 2-star
                chosen = twoStars.get(rng.nextInt(twoStars.size()));
            } else {
                chosen = oneStars.get(rng.nextInt(oneStars.size()));
            }
        } else if (item.getType() == Material.DIAMOND_PICKAXE) {
            int roll = rng.nextInt(10);

            if (roll < 1) { // 10% for 3-star
                chosen = threeStars.get(rng.nextInt(threeStars.size()));
            } else if (roll < 5) { // 40% for 2-star
                chosen = twoStars.get(rng.nextInt(twoStars.size()));
            } else {
                chosen = oneStars.get(rng.nextInt(oneStars.size()));
            }
        } else if (item.getType() == Material.NETHERITE_PICKAXE) {
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
