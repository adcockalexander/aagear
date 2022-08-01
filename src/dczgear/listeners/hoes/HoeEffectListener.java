package dczgear.listeners.hoes;

import dczgear.utility.EffectParser;
import dczgear.utility.LevelParser;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class HoeEffectListener implements Listener {

    private static Plugin plugin;

    public HoeEffectListener(Plugin plugin) {
        this.plugin = plugin;
    }

    private static final Set<Material> crops = Set.of(
            Material.WHEAT,
            Material.CARROTS,
            Material.BEETROOTS,
            Material.SUGAR_CANE
    );

    private static final Map<Material, Material> seedMap = Map.of(
            Material.WHEAT, Material.WHEAT_SEEDS,
            Material.CARROTS, Material.CARROT,
            Material.BEETROOTS, Material.BEETROOT_SEEDS,
            Material.SUGAR_CANE, Material.SUGAR_CANE
    );

    private static final List<String> upgradeableLores = List.of(
            "drops from wheat farming",
            "drops from carrot farming",
            "drops from beetroot farming",
            "drops from sugarcane farming",
            "tool XP gain"
    );

    private static final String greenFingersLore = ChatColor.GREEN + "" + ChatColor.BOLD + "Green Fingers";
    private static final String caneRefinerLore = ChatColor.YELLOW + "" + ChatColor.BOLD + "Cane Refiner";
    private static final String hayStackerLore = ChatColor.GOLD + "" + ChatColor.BOLD + "Hay Stacker";
    private static final String autoReplantLore = ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Auto Replant";
    private static final String megaReplantLore = ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Mega Replant";

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onBlockBreak(BlockBreakEvent event) {
        if (event.isCancelled()) return;

        Player ply = event.getPlayer();
        ItemStack item = ply.getInventory().getItemInMainHand();

        ItemMeta itemMeta = item.getItemMeta();

        if (itemMeta == null) return;

        List<String> lore = itemMeta.getLore();

        if (lore == null) return;

        Material mat = item.getType();

        if (mat == Material.WOODEN_HOE
                || mat == Material.STONE_HOE
                || mat == Material.IRON_HOE
                || mat == Material.GOLDEN_HOE
                || mat == Material.DIAMOND_HOE
                || mat == Material.NETHERITE_HOE
        ) {
            Block block = event.getBlock();
            Material blockType = block.getType();

            if (crops.contains(blockType)) {
                if (blockType != Material.SUGAR_CANE) { // If not sugarcane, check if crop is fully grown
                    Ageable ageable = (Ageable)block.getBlockData();

                    if (ageable.getAge() != ageable.getMaximumAge()) return;
                }

                if (blockType == Material.WHEAT) {
                    int wheatEffect = EffectParser.parseEffectMagnitude(lore, 3, "% drops from wheat farming");

                    Random rng = new Random();
                    int roll = rng.nextInt(100);

                    if (roll < wheatEffect) {
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.WHEAT, 1));
                    }

                    if (lore.contains(hayStackerLore)) {
                        roll = rng.nextInt(100);

                        if (roll < 2) {
                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.HAY_BLOCK, 1));
                        }
                    }
                } else if (blockType == Material.BEETROOTS) {
                    int beetrootEffect = EffectParser.parseEffectMagnitude(lore, 3, "% drops from beetroot farming");

                    Random rng = new Random();
                    int roll = rng.nextInt(100);

                    if (roll < beetrootEffect) {
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.BEETROOT, 1));
                    }

                    if (lore.contains(greenFingersLore)) {
                        roll = rng.nextInt(100);

                        if (roll < 2) {
                            int drop = rng.nextInt(9) + 8;

                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.BEETROOT, drop));
                        }
                    }
                } else if (blockType == Material.CARROTS) {
                    int carrotEffect = EffectParser.parseEffectMagnitude(lore, 3, "% drops from carrot farming");

                    Random rng = new Random();
                    int roll = rng.nextInt(100);

                    if (roll < carrotEffect) {
                        int fortune = itemMeta.getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);
                        int drop = simulateFortuneForCarrots(fortune);

                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.CARROT, drop));
                    }

                    if (lore.contains(greenFingersLore)) {
                        roll = rng.nextInt(100);

                        if (roll < 2) {
                            int drop = rng.nextInt(9) + 8;

                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.CARROT, drop));
                        }
                    }
                } else if (blockType == Material.SUGAR_CANE) {
                    boolean caneRefiner = (lore.contains(caneRefinerLore));

                    int sugarcaneEffect = EffectParser.parseEffectMagnitude(lore, 3, "% drops from sugarcane farming");

                    Random rng = new Random();
                    int roll = rng.nextInt(100);

                    if (roll < sugarcaneEffect) {
                        int drop = 1;

                        // We actually need to check the 2 blocks above to see how much sugarcane is being broken
                        Location up = block.getLocation().add(0, 1, 0);
                        if (up.getBlock().getType() == Material.SUGAR_CANE) {
                            drop++;
                        }

                        up.add(0, 1, 0);
                        if (up.getBlock().getType() == Material.SUGAR_CANE) {
                            drop++;
                        }

                        if (caneRefiner) {
                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SUGAR, drop));
                        } else {
                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SUGAR_CANE, drop));
                        }
                    }

                    if (caneRefiner) {
                        event.setCancelled(true);

                        int sugar = 1;

                        // Remove this sugarcane and everything above it
                        block.setType(Material.AIR);

                        Location up = block.getLocation().add(0, 1, 0);
                        if (up.getBlock().getType() == Material.SUGAR_CANE) {
                            up.getBlock().setType(Material.AIR);
                            sugar++;
                        }

                        up.add(0, 1, 0);
                        if (up.getBlock().getType() == Material.SUGAR_CANE) {
                            up.getBlock().setType(Material.AIR);
                            sugar++;
                        }

                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SUGAR, sugar));
                    }
                }

                int level = -1;

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

                boolean autoReplant = lore.contains(autoReplantLore);
                boolean megaReplant = lore.contains(megaReplantLore);

                if (autoReplant || megaReplant) {
                    boolean replant = true;

                    if (autoReplant) {
                        Material seeds = seedMap.get(blockType);
                        if (seeds == null) replant = false;

                        // This function returns a map of amounts & itemstacks it failed to remove
                        Map<Integer, ItemStack> failureMap = ply.getInventory().removeItem(new ItemStack(seeds, 1));

                        // So if the map is not empty, we know we couldn't find any seeds to use
                        if (!failureMap.isEmpty()) replant = false;
                    }

                    if (replant) {
                        Location loc = block.getLocation();

                        if (blockType == Material.SUGAR_CANE) {
                            loc.add(0, -1, 0);
                            if (loc.getBlock().getType() != Material.SUGAR_CANE) {
                                loc.add(0, 1, 0);
                                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                    loc.getBlock().setType(blockType);
                                }, 20L);
                            }
                        } else {
                            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                loc.getBlock().setType(blockType);
                            }, 20L);
                        }
                    }
                }
            }
        }
    }

    private static int simulateFortuneForCarrots(int fortune) {
        int carrots = 2;
        int rolls = fortune + 3;

        Random rng = new Random();

        while (rolls > 0) {
            int roll = rng.nextInt(100);

            if (roll < 57) {
                carrots++;
            }

            rolls--;
        }

        return carrots;
    }

}
