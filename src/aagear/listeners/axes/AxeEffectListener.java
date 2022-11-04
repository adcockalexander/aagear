package aagear.listeners.axes;

import aagear.utility.EffectParser;
import aagear.utility.LevelParser;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Cocoa;
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

public class AxeEffectListener implements Listener {

    private static Plugin plugin;

    public AxeEffectListener(Plugin plugin) {
        AxeEffectListener.plugin = plugin;
    }

    private static final Set<Material> crops = Set.of(
            Material.MELON,
            Material.PUMPKIN,
            Material.COCOA
    );

    private static final Map<Material, Material> logMap = Map.ofEntries(
            Map.entry(Material.ACACIA_LOG, Material.ACACIA_SAPLING),
            Map.entry(Material.BIRCH_LOG, Material.BIRCH_SAPLING),
            Map.entry(Material.DARK_OAK_LOG, Material.DARK_OAK_SAPLING),
            Map.entry(Material.JUNGLE_LOG, Material.JUNGLE_SAPLING),
            Map.entry(Material.MANGROVE_LOG, Material.MANGROVE_PROPAGULE),
            Map.entry(Material.OAK_LOG, Material.OAK_SAPLING),
            Map.entry(Material.SPRUCE_LOG, Material.SPRUCE_SAPLING),
            Map.entry(Material.STRIPPED_ACACIA_LOG, Material.ACACIA_SAPLING),
            Map.entry(Material.STRIPPED_BIRCH_LOG, Material.BIRCH_SAPLING),
            Map.entry(Material.STRIPPED_DARK_OAK_LOG, Material.DARK_OAK_SAPLING),
            Map.entry(Material.STRIPPED_JUNGLE_LOG, Material.JUNGLE_SAPLING),
            Map.entry(Material.STRIPPED_MANGROVE_LOG, Material.MANGROVE_PROPAGULE),
            Map.entry(Material.STRIPPED_OAK_LOG, Material.OAK_SAPLING),
            Map.entry(Material.STRIPPED_SPRUCE_LOG, Material.SPRUCE_SAPLING)
    );

    private static final List<String> upgradeableLores = List.of(
            "drops from melon farming",
            "drops from pumpkin farming",
            "drops from cocoa farming",
            "drops from tree farming",
            "tool XP gain",
            "chance to gain XP when farming"
    );

    private static final String sweetToothLore = ChatColor.DARK_RED + "" + ChatColor.BOLD + "Sweet Tooth";
    private static final String farmingHaulLore = ChatColor.GREEN + "" + ChatColor.BOLD + "Farming Haul";
    private static final String treeSplitterLore = ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Tree Splitter";
    private static final String cocoaReplantLore = ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Cocoa Replant";
    private static final String treeReplantLore = ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Tree Replant";
    private static final String cropShatterLore = ChatColor.RED + "" + ChatColor.BOLD + "Crop Shatter";
    private static final String megaShatterLore = ChatColor.GOLD + "" + ChatColor.BOLD + "Mega Shatter";
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

        boolean silkTouch = (itemMeta.getEnchantLevel(Enchantment.SILK_TOUCH) > 0);

        if (mat == Material.WOODEN_AXE
                || mat == Material.STONE_AXE
                || mat == Material.IRON_AXE
                || mat == Material.GOLDEN_AXE
                || mat == Material.DIAMOND_AXE
                || mat == Material.NETHERITE_AXE
        ) {
            Block block = event.getBlock();
            Material blockType = block.getType();

            Material sapling;

            boolean triggered = false;

            if (crops.contains(blockType)) {
                triggered = true;

                if (blockType == Material.MELON) {
                    int melonEffect = EffectParser.parseEffectMagnitude(lore, 3, "% drops from melon farming");

                    Random rng = new Random();
                    int roll = rng.nextInt(100);

                    if (roll < melonEffect) {
                        if (silkTouch) {
                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.MELON, 1));
                        } else {
                            int fortune = itemMeta.getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);

                            // Fortune for melons uses a discrete random distribution, and caps at 9 slices.
                            int drop = Math.min(rng.nextInt(5 + fortune) + 3, 9);

                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.MELON_SLICE, drop));
                        }
                    }

                    if (lore.contains(farmingHaulLore)) {
                        roll = rng.nextInt(100);

                        if (roll < 2) {
                            if (silkTouch) {
                                int drop = rng.nextInt(9) + 8;

                                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.MELON, drop));
                            } else {
                                int drop = rng.nextInt(33) + 32;

                                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.MELON_SLICE, drop));
                            }
                        }
                    } else if (lore.contains(cropShatterLore)) {
                        roll = rng.nextInt(100);

                        if (roll < 10) {
                            int drop = shatterBlocks(block.getLocation(), blockType, 1, 2);

                            if (silkTouch) {
                                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.MELON, drop));
                            } else {
                                int fortune = itemMeta.getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);

                                // Fortune for melons uses a discrete random distribution, and caps at 9 slices.
                                int slices = Math.min(rng.nextInt(5 + fortune) + 3, 9);

                                drop *= slices;

                                while (drop > 0) {
                                    if (drop > 64) {
                                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.MELON_SLICE, 64));
                                        drop -= 64;
                                    } else {
                                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.MELON_SLICE, drop));
                                        drop = 0;
                                    }
                                }
                            }
                        }
                    } else if (lore.contains(megaShatterLore)) {
                        roll = rng.nextInt(100);

                        if (roll < 15) {
                            int drop = shatterBlocks(block.getLocation(), blockType, 2, 2);

                            if (silkTouch) {
                                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.MELON, drop));
                            } else {
                                int fortune = itemMeta.getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);

                                // Fortune for melons uses a discrete random distribution, and caps at 9 slices.
                                int slices = Math.min(rng.nextInt(5 + fortune) + 3, 9);

                                drop *= slices;

                                while (drop > 0) {
                                    if (drop > 64) {
                                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.MELON_SLICE, 64));
                                        drop -= 64;
                                    } else {
                                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.MELON_SLICE, drop));
                                        drop = 0;
                                    }
                                }
                            }
                        }
                    }
                } else if (blockType == Material.PUMPKIN) {
                    int pumpkinEffect = EffectParser.parseEffectMagnitude(lore, 3, "% drops from pumpkin farming");

                    Random rng = new Random();
                    int roll = rng.nextInt(100);

                    if (roll < pumpkinEffect) {
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.PUMPKIN, 1));
                    }

                    if (lore.contains(farmingHaulLore)) {
                        roll = rng.nextInt(100);

                        if (roll < 2) {
                            int drop = rng.nextInt(9) + 8;

                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.PUMPKIN, drop));
                        }
                    } else if (lore.contains(cropShatterLore)) {
                        roll = rng.nextInt(100);

                        if (roll < 10) {
                            int drop = shatterBlocks(block.getLocation(), blockType, 1, 2);

                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.PUMPKIN, drop));
                        }
                    } else if (lore.contains(megaShatterLore)) {
                        roll = rng.nextInt(100);

                        if (roll < 15) {
                            int drop = shatterBlocks(block.getLocation(), blockType, 2, 2);

                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.PUMPKIN, drop));
                        }
                    }
                } else if (blockType == Material.COCOA) {
                    int cocoaEffect = EffectParser.parseEffectMagnitude(lore, 3, "% drops from cocoa farming");

                    Random rng = new Random();
                    int roll = rng.nextInt(100);

                    if (roll < cocoaEffect) {
                        // 50/50 chance of 2 or 3 cocoa beans

                        roll = rng.nextInt(2);

                        if (roll == 0) {
                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COCOA_BEANS, 2));
                        } else {
                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COCOA_BEANS, 3));
                        }
                    }

                    if (lore.contains(sweetToothLore)) {
                        roll = rng.nextInt(100);

                        if (roll < 2) {
                            int drop = rng.nextInt(33) + 32;

                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COOKIE, drop));
                        }
                    }

                    if (lore.contains(cocoaReplantLore)) {
                        // Get the direction the cocoa is facing
                        BlockFace face = ((Cocoa)block.getBlockData()).getFacing();

                        // This function returns a map of amounts & itemstacks it failed to remove
                        Map<Integer, ItemStack> failureMap = ply.getInventory().removeItem(new ItemStack(Material.COCOA_BEANS, 1));

                        // So if the map is empty, we know we found cocoa to use
                        if (failureMap.isEmpty()) {
                            Location loc = block.getLocation();

                            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                loc.getBlock().setType(blockType);

                                // Set the cocoa to face in the correct direction
                                Cocoa cocoa = (Cocoa)loc.getBlock().getBlockData();
                                cocoa.setFacing(face);
                                loc.getBlock().setBlockData(cocoa);
                            }, 20L);
                        }
                    } else if (lore.contains(megaReplantLore)) {
                        BlockFace face = ((Cocoa)block.getBlockData()).getFacing();

                        Location loc = block.getLocation();

                        Bukkit.getScheduler().runTaskLater(plugin, () -> {
                            loc.getBlock().setType(blockType);

                            Cocoa cocoa = (Cocoa)loc.getBlock().getBlockData();
                            cocoa.setFacing(face);
                            loc.getBlock().setBlockData(cocoa);
                        }, 20L);
                    }
                }
            } else if ((sapling = logMap.get(blockType)) != null) {
                triggered = true;

                int treeEffect = EffectParser.parseEffectMagnitude(lore, 3, "% drops from tree farming");

                Random rng = new Random();
                int roll = rng.nextInt(100);

                if (roll < treeEffect) {
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(blockType, 1));
                }

                if (lore.contains(treeSplitterLore)) {
                    roll = rng.nextInt(100);

                    if (roll < 20) {
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(blockType, 1));
                    }
                }

                if (lore.contains(treeReplantLore)) {
                    Location loc = block.getLocation();
                    loc.add(0, -1, 0);

                    if (loc.getBlock().getType() == Material.DIRT ||
                            loc.getBlock().getType() == Material.COARSE_DIRT ||
                            loc.getBlock().getType() == Material.ROOTED_DIRT ||
                            (blockType == Material.MANGROVE_PROPAGULE && loc.getBlock().getType() == Material.MUD)) {
                        // This function returns a map of amounts & itemstacks it failed to remove
                        Map<Integer, ItemStack> failureMap = ply.getInventory().removeItem(new ItemStack(sapling, 1));

                        // So if the map is empty, we know we found a sapling to use
                        if (failureMap.isEmpty()) {
                            Location finalLoc = block.getLocation();

                            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                finalLoc.getBlock().setType(sapling);
                            }, 20L);
                        }
                    }
                } else if (lore.contains(megaReplantLore)) {
                    Location loc = block.getLocation();
                    loc.add(0, -1, 0);

                    if (loc.getBlock().getType() == Material.DIRT ||
                            loc.getBlock().getType() == Material.COARSE_DIRT ||
                            loc.getBlock().getType() == Material.ROOTED_DIRT ||
                            (blockType == Material.MANGROVE_PROPAGULE && loc.getBlock().getType() == Material.MUD)) {
                        Location finalLoc = block.getLocation();

                        Bukkit.getScheduler().runTaskLater(plugin, () -> {
                            finalLoc.getBlock().setType(sapling);
                        }, 20L);
                    }
                }
            }

            if (triggered) {
                int gainXPEffect = EffectParser.parseEffectMagnitude(lore, 3, "% chance to gain XP when farming");

                Random rng = new Random();
                int roll = rng.nextInt(100);

                if (roll < gainXPEffect) {
                    ply.giveExp(1);
                }

                int level = -1;

                int toolXPEffect = EffectParser.parseEffectMagnitude(lore, 3, "% tool XP gain");

                if (toolXPEffect != -1) {
                    int roll2 = rng.nextInt(100);

                    if (roll2 < toolXPEffect) {
                        level = LevelParser.addXPIfEligible(ply, item, 2);
                    } else {
                        level = LevelParser.addXPIfEligible(ply, item, 1);
                    }
                } else {
                    level = LevelParser.addXPIfEligible(ply, item, 1);
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
    }

    // Shatters blocks within a given distance. Returns the amount of extra drops to provide.
    private static int shatterBlocks(Location centre, Material mat, int distance, int dropMultiplier) {
        if (distance == 0) return dropMultiplier - 1; // This is equivalent to just breaking the centre block

        int centreX = centre.getBlockX();
        int y = centre.getBlockY();
        int centreZ = centre.getBlockZ();

        World world = centre.getWorld();

        int drop = dropMultiplier - 1;

        for (int x = centreX - (distance - 1); x <= centreX + (distance + 1); x++) {
            for (int z = centreZ - (distance - 1); z <= centreZ + (distance + 1); z++) {
                Location loc = new Location(world, x, y, z);

                Block block = loc.getBlock();

                if (block.getType() == mat) {
                    block.setType(Material.AIR);
                    drop += dropMultiplier;
                }
            }
        }

        return drop;
    }
}

