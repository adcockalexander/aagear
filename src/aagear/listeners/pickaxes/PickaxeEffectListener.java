package aagear.listeners.pickaxes;

import aagear.utility.EffectParser;
import aagear.utility.LevelParser;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class PickaxeEffectListener implements Listener {

    private static final Map<Material, Integer> expMap = Map.ofEntries(
            Map.entry(Material.COAL_ORE, 1),
            Map.entry(Material.DEEPSLATE_COAL_ORE, 1),
            Map.entry(Material.DIAMOND_ORE, 5),
            Map.entry(Material.DEEPSLATE_DIAMOND_ORE, 5),
            Map.entry(Material.EMERALD_ORE, 5),
            Map.entry(Material.DEEPSLATE_EMERALD_ORE, 5),
            Map.entry(Material.LAPIS_ORE, 4),
            Map.entry(Material.DEEPSLATE_LAPIS_ORE, 5),
            Map.entry(Material.NETHER_QUARTZ_ORE, 4),
            Map.entry(Material.REDSTONE_ORE, 3),
            Map.entry(Material.DEEPSLATE_REDSTONE_ORE, 3),
            Map.entry(Material.NETHER_GOLD_ORE, 1)
    );

    private static final Set<Material> ores = Set.of(
            Material.COAL_ORE,
            Material.LAPIS_ORE,
            Material.REDSTONE_ORE,
            Material.IRON_ORE,
            Material.DIAMOND_ORE,
            Material.DEEPSLATE_COAL_ORE,
            Material.DEEPSLATE_LAPIS_ORE,
            Material.DEEPSLATE_REDSTONE_ORE,
            Material.DEEPSLATE_DIAMOND_ORE,
            Material.DEEPSLATE_EMERALD_ORE,
            Material.DEEPSLATE_IRON_ORE,
            Material.EMERALD_ORE,
            Material.NETHER_GOLD_ORE,
            Material.NETHER_QUARTZ_ORE,
            Material.COPPER_ORE,
            Material.DEEPSLATE_COPPER_ORE,
            Material.GOLD_ORE,
            Material.DEEPSLATE_GOLD_ORE
    );

    private static final String midasTouchLore = ChatColor.GOLD + "" + ChatColor.BOLD + "Midas Touch";
    private static final String tackyDecorationLore = ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Tacky Decoration";
    private static final String electroChargedLore = ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Electro-charged";
    private static final String latentHeatLore = ChatColor.RED + "" + ChatColor.BOLD + "Latent Heat";
    private static final String crystalliseLore = ChatColor.AQUA + "" + ChatColor.BOLD + "Crystallise";
    private static final String skywardCrystalliseLore = ChatColor.AQUA + "" + ChatColor.BOLD + "Skyward Crystallise";
    private static final String experiencedLore = ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Experienced";
    private static final String dragonTransfusionLore = ChatColor.DARK_RED + "" + ChatColor.BOLD + "Dragon Transfusion";

    private static final List<String> upgradeableLores = List.of(
            "drops from diamond ore",
            "drops from emerald ore",
            "drops from redstone ore",
            "drops from lapis ore",
            "drops from coal ore",
            "drops from gold ore",
            "drops from iron ore",
            "XP from ores",
            "tool XP gain"
    );

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onBlockBreak(BlockBreakEvent event) {
        if (event.isCancelled()) return;

        Player ply = event.getPlayer();
        ItemStack item = ply.getInventory().getItemInMainHand();

        ItemMeta itemMeta = item.getItemMeta();

        if (itemMeta == null) return;

        List<String> lore = itemMeta.getLore();

        if (lore == null) return;

        int silkTouch = itemMeta.getEnchantLevel(Enchantment.SILK_TOUCH);

        if (silkTouch > 0) return;

        Material mat = item.getType();

        if (mat == Material.WOODEN_PICKAXE
                || mat == Material.STONE_PICKAXE
                || mat == Material.IRON_PICKAXE
                || mat == Material.GOLDEN_PICKAXE
                || mat == Material.DIAMOND_PICKAXE
                || mat == Material.NETHERITE_PICKAXE
        ) {
            Block block = event.getBlock();
            Material blockType = block.getType();

            if (blockType == Material.COAL_ORE || blockType == Material.DEEPSLATE_COAL_ORE) {
                int coalEffect = EffectParser.parseEffectMagnitude(lore, 3, "% drops from coal ore");

                Random rng = new Random();
                int roll = rng.nextInt(100);

                if (roll < coalEffect) {
                    int fortune = itemMeta.getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);

                    ItemStack drop = new ItemStack(Material.COAL, simulateDrop(1, fortune));

                    block.getWorld().dropItemNaturally(block.getLocation(), drop);
                }
            } else if (blockType == Material.IRON_ORE || blockType == Material.DEEPSLATE_IRON_ORE) {
                if (lore.contains(latentHeatLore)) { // this assumes I never put a + iron perk on a latent heat pickaxe
                    event.setDropItems(false);

                    ItemStack drop = new ItemStack(Material.IRON_INGOT, 2);
                    block.getWorld().dropItemNaturally(block.getLocation(), drop);
                } else {
                    int ironEffect = EffectParser.parseEffectMagnitude(lore, 3, "% drops from iron ore");

                    Random rng = new Random();
                    int roll = rng.nextInt(100);

                    if (roll < ironEffect) {
                        int fortune = itemMeta.getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);

                        ItemStack drop = new ItemStack(Material.RAW_IRON, simulateDrop(1, fortune));

                        block.getWorld().dropItemNaturally(block.getLocation(), drop);
                    }
                }
            } else if (blockType == Material.GOLD_ORE || blockType == Material.DEEPSLATE_GOLD_ORE) {
                if (lore.contains(latentHeatLore)) {
                    event.setDropItems(false);

                    ItemStack drop = new ItemStack(Material.GOLD_INGOT, 2);
                    block.getWorld().dropItemNaturally(block.getLocation(), drop);
                }
            } else if (blockType == Material.REDSTONE_ORE || blockType == Material.DEEPSLATE_REDSTONE_ORE) {
                int redstoneEffect = EffectParser.parseEffectMagnitude(lore, 3, "% drops from redstone ore");

                Random rng = new Random();
                int roll = rng.nextInt(100);

                if (roll < redstoneEffect) {
                    int fortune = itemMeta.getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);

                    ItemStack drop = new ItemStack(Material.REDSTONE, simulateDrop(4, fortune));

                    block.getWorld().dropItemNaturally(block.getLocation(), drop);
                }
            } else if (blockType == Material.LAPIS_ORE || blockType == Material.DEEPSLATE_LAPIS_ORE) {
                int lapisEffect = EffectParser.parseEffectMagnitude(lore, 3, "% drops from lapis ore");

                Random rng = new Random();
                int roll = rng.nextInt(100);

                if (roll < lapisEffect) {
                    int fortune = itemMeta.getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);

                    ItemStack drop = new ItemStack(Material.LAPIS_LAZULI, simulateDrop(6, fortune));

                    block.getWorld().dropItemNaturally(block.getLocation(), drop);
                }
            } else if (blockType == Material.DIAMOND_ORE || blockType == Material.DEEPSLATE_DIAMOND_ORE) {
                int diamondEffect = EffectParser.parseEffectMagnitude(lore, 3, "% drops from diamond ore");

                Random rng = new Random();
                int roll = rng.nextInt(100);

                if (roll < diamondEffect) {
                    int fortune = itemMeta.getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);

                    ItemStack drop = new ItemStack(Material.DIAMOND, simulateDrop(1, fortune));

                    block.getWorld().dropItemNaturally(block.getLocation(), drop);
                }
            } else if (blockType == Material.EMERALD_ORE || blockType == Material.DEEPSLATE_EMERALD_ORE) {
                int emeraldEffect = EffectParser.parseEffectMagnitude(lore, 3, "% drops from emerald ore");

                Random rng = new Random();
                int roll = rng.nextInt(100);

                if (roll < emeraldEffect) {
                    int fortune = itemMeta.getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);

                    ItemStack drop = new ItemStack(Material.EMERALD, simulateDrop(1, fortune));

                    block.getWorld().dropItemNaturally(block.getLocation(), drop);
                }
            }

            int level = -1;

            if (ores.contains(blockType)) {
                int toolXPEffect = EffectParser.parseEffectMagnitude(lore, 3, "% tool XP gain");

                if (toolXPEffect != -1) {
                    Random rng = new Random();
                    int roll = rng.nextInt(100);

                    if (roll < toolXPEffect) {
                        level = LevelParser.addXPIfEligible(ply, item, 4);
                    } else {
                        level = LevelParser.addXPIfEligible(ply, item, 2);
                    }
                } else {
                    level = LevelParser.addXPIfEligible(ply, item, 2);
                }

                int xpEffect = EffectParser.parseEffectMagnitude(lore, 3, "% XP from ores");

                if (xpEffect != -1) {
                    Random rng = new Random();
                    int roll = rng.nextInt(100);

                    if (roll < xpEffect) {
                        Integer xpBonus = expMap.get(blockType);

                        if (xpBonus != null) {
                            ply.giveExp(xpBonus);
                        }
                    }
                }

                if (lore.contains(tackyDecorationLore)) {
                    Random rng = new Random();
                    int roll = rng.nextInt(100);

                    if (roll < 5) {
                        int amount = rng.nextInt(17) + 16; // between 16 - 32

                        ItemStack drop = new ItemStack(Material.LAPIS_LAZULI, amount);

                        block.getWorld().dropItemNaturally(block.getLocation(), drop);
                    }
                } else if (lore.contains(electroChargedLore)) {
                    Random rng = new Random();
                    int roll = rng.nextInt(100);

                    if (roll < 5) {
                        int amount = rng.nextInt(17) + 16; // between 16 - 32

                        ItemStack drop = new ItemStack(Material.REDSTONE, amount);

                        block.getWorld().dropItemNaturally(block.getLocation(), drop);
                    }
                } else if (lore.contains(dragonTransfusionLore)) {
                    int drop = -1;

                    if (blockType == Material.REDSTONE_ORE || blockType == Material.DEEPSLATE_REDSTONE_ORE) {
                        Random rng = new Random();
                        int roll = rng.nextInt(100);

                        if (roll < 5) {
                            int fortune = itemMeta.getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);

                            drop = simulateDrop(4, fortune);
                        }
                    } else if (blockType == Material.LAPIS_ORE || blockType == Material.DEEPSLATE_LAPIS_ORE) {
                        Random rng = new Random();
                        int roll = rng.nextInt(100);

                        if (roll < 5) {
                            int fortune = itemMeta.getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);

                            drop = simulateDrop(6, fortune);
                        }
                    }

                    if (drop > 0) {
                        event.setCancelled(true);
                        event.getBlock().setType(Material.AIR);

                        Random rng = new Random();
                        int typeRoll = rng.nextInt(10);

                        if (typeRoll < 2) {
                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.DIAMOND, drop));
                        } else if (typeRoll < 4) {
                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.EMERALD, drop));
                        } else {
                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GOLD_INGOT, drop));
                        }
                    }
                } else if (lore.contains(experiencedLore)) {
                    Random rng = new Random();
                    int roll = rng.nextInt(100);

                    if (roll < 5) {
                        int amount = rng.nextInt(17) + 16;

                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.EXPERIENCE_BOTTLE, amount));
                    }
                }
            } else if (blockType == Material.STONE) {
                int toolXPEffect = EffectParser.parseEffectMagnitude(lore, 3, "% tool XP gain");

                if (toolXPEffect != -1) {
                    Random rng = new Random();
                    int roll = rng.nextInt(100);

                    if (roll < toolXPEffect) {
                        level = LevelParser.addXPIfEligible(ply, item, 2);
                    } else {
                        level = LevelParser.addXPIfEligible(ply, item, 1);
                    }
                } else {
                    level = LevelParser.addXPIfEligible(ply, item, 1);
                }

                if (lore.contains(midasTouchLore)) {
                    Random rng = new Random();
                    int roll = rng.nextInt(100);

                    if (roll == 0) {
                        ItemStack drop = new ItemStack(Material.GOLD_BLOCK, 1);

                        block.getWorld().dropItemNaturally(block.getLocation(), drop);
                    }
                } else if (lore.contains(crystalliseLore)) {
                    Random rng = new Random();
                    int roll = rng.nextInt(100);

                    if (roll == 0) {
                        event.setCancelled(true);

                        int typeRoll = rng.nextInt(2);
                        int maxOresRoll = rng.nextInt(5) + 4; // between 4-8

                        if (typeRoll == 0) {
                            generateOreVein(block.getLocation(), Material.DIAMOND_ORE, maxOresRoll, null, 0);
                        } else {
                            generateOreVein(block.getLocation(), Material.EMERALD_ORE, maxOresRoll, null, 0);
                        }
                    }
                } else if (lore.contains(skywardCrystalliseLore)) {
                    Random rng = new Random();
                    int roll = rng.nextInt(200);

                    if (roll < 3) { // 3/200 == 1.5% chance
                        event.setCancelled(true);

                        int typeRoll = rng.nextInt(2);
                        int maxOresRoll = rng.nextInt(5) + 4; // between 4-8

                        if (typeRoll == 0) {
                            generateOreVein(block.getLocation(), Material.DIAMOND_ORE, maxOresRoll, Material.DIAMOND_BLOCK, 10);
                        } else {
                            generateOreVein(block.getLocation(), Material.EMERALD_ORE, maxOresRoll, Material.EMERALD_BLOCK, 10);
                        }
                    }
                } else if (lore.contains(experiencedLore)) {
                    Random rng = new Random();
                    int roll = rng.nextInt(100);

                    if (roll == 0) {
                        int amount = rng.nextInt(17) + 16;

                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.EXPERIENCE_BOTTLE, amount));
                    }
                }
            } else if (blockType == Material.OBSIDIAN) {
                level = LevelParser.addXPIfEligible(ply, item, 5);
            }

            if (level != -1) {
                int percent = level + LevelParser.getMaxLevel(item);

                itemMeta = item.getItemMeta();
                lore = itemMeta.getLore();

                for (String upgradeableLore : upgradeableLores) {
                    int loreCounter = 0;

                    while (loreCounter < lore.size()) {
                        if (lore.get(loreCounter).contains(upgradeableLore)) {
                            String upgradedLore = ChatColor.GREEN + "+" + percent + "% " + upgradeableLore;

                            lore.set(loreCounter, upgradedLore);

                            break;
                        }

                        loreCounter++;
                    }
                }

                itemMeta.setLore(lore);
                item.setItemMeta(itemMeta);
            }
        }
    }

    private static int simulateDrop(int baseDrop, int fortune) {
        return baseDrop * returnFortuneMultiplier(fortune);
    }

    private static int returnFortuneMultiplier(int fortune) {
        if (fortune <= 0) return 1;

        Random rng = new Random();
        int roll = rng.nextInt(1000); // generates between 0-999

        int rollSum = -1;
        int rollStep = 1000 / (fortune + 2);
        int multiplier = fortune + 1;

        // e.g. at fortune 3, we check every 1000/5 = 200 units
        while (multiplier > 1) {
            rollSum += rollStep;

            if (roll <= rollSum) { // If we rolled at or below the mark, return this multiplier
                return multiplier;
            }

            multiplier--;
        }

        return 1;
    }

    private static void generateOreVein(Location centre, Material mat, int maxOres, Material secondaryMat, int secondaryChance) {
        int rollTarget = 30; // This means '30% chance' an eligible block can become ore. Tweak as necessary

        int centreX = centre.getBlockX();
        int centreY = centre.getBlockY();
        int centreZ = centre.getBlockZ();

        centre.getBlock().setType(mat);
        maxOres--;

        if (maxOres <= 0) return;

        World world = centre.getWorld();
        Random rng = new Random();

        // Up to 27 iterations (3*3*3). We check all possible locations and try to place ore here.
        for (int x = centreX - 1; x <= centreX + 1; x++) {
            for (int y = centreY - 1; y <= centreY + 1; y++) {
                for (int z = centreZ - 1; z <= centreZ + 1; z++) {
                    int roll = rng.nextInt(100);

                    if (roll < rollTarget) {
                        Location loc = new Location(world, x, y, z);

                        Block block = loc.getBlock();

                        if (block.getType() == Material.STONE) {
                            if (secondaryMat != null) {
                                int secondaryRoll = rng.nextInt(100);
                                if (secondaryRoll < secondaryChance) {
                                    block.setType(secondaryMat);
                                } else {
                                    block.setType(mat);
                                }
                            } else {
                                block.setType(mat);
                            }

                            maxOres--;

                            if (maxOres <= 0) return;
                        }
                    }
                }
            }
        }
    }
}
