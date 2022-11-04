package aagear.listeners.shovels;

import aagear.utility.EffectParser;
import aagear.utility.LevelParser;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class ShovelEffectListener implements Listener {

    private static final Set<Material> shovelBlocks = Set.of(
            Material.DIRT,
            Material.SAND,
            Material.GRAVEL
    );

    private static final List<String> upgradeableLores = List.of(
            "random drops from dirt",
            "random drops from sand & gravel",
            "tool XP gain"
    );

    private static final String detonateLore = ChatColor.RED + "" + ChatColor.BOLD + "Detonate";
    private static final String meltLore = ChatColor.DARK_RED + "" + ChatColor.BOLD + "Melt";

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

        if (mat == Material.WOODEN_SHOVEL
                || mat == Material.STONE_SHOVEL
                || mat == Material.IRON_SHOVEL
                || mat == Material.GOLDEN_SHOVEL
                || mat == Material.DIAMOND_SHOVEL
                || mat == Material.NETHERITE_SHOVEL
        ) {
            Block block = event.getBlock();
            Material blockType = block.getType();

            if (shovelBlocks.contains(blockType)) {
                if (blockType == Material.DIRT) {
                    int dirtEffect = EffectParser.parseEffectMagnitude(lore, 3, "% random drops from dirt");

                    Random rng = new Random();
                    int roll = rng.nextInt(100);

                    if (roll < dirtEffect) {
                        ItemStack drop = generateRandomDrop();

                        block.getWorld().dropItemNaturally(block.getLocation(), drop);
                    }
                } else if (blockType == Material.SAND || blockType == Material.GRAVEL) {
                    int dirtEffect = EffectParser.parseEffectMagnitude(lore, 3, "% random drops from sand & gravel");

                    Random rng = new Random();
                    int roll = rng.nextInt(100);

                    if (roll < dirtEffect) {
                        ItemStack drop = generateRandomDrop();

                        block.getWorld().dropItemNaturally(block.getLocation(), drop);
                    }

                    if (blockType == Material.SAND && lore.contains(meltLore)) {
                        ItemStack offHand = ply.getInventory().getItemInOffHand();
                        Material offHandType = offHand.getType();

                        if (offHandType != Material.WATER_BUCKET) {
                            event.setCancelled(true);
                            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GLASS, 1));
                            block.setType(Material.AIR);
                        }
                    }
                }

                if (lore.contains(detonateLore)) {
                    Random rng = new Random();
                    int roll = rng.nextInt(100);

                    if (roll < 10) {
                        detonateBlocks(block.getLocation());
                    }
                }

                int level = -1;

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

    private static ItemStack generateRandomDrop() {
        Random rng = new Random();

        int roll = rng.nextInt(100);

        Material mat;

        if (roll < 1) {
            mat = Material.EMERALD;
        } else if (roll < 2) {
            mat = Material.DIAMOND;
        } else if (roll < 5) {
            mat = Material.RAW_GOLD;
        } else if (roll < 10) {
            mat = Material.RAW_IRON;
        } else if (roll < 15) {
            mat = Material.REDSTONE;
        } else if (roll < 20) {
            mat = Material.LAPIS_LAZULI;
        } else if (roll < 35) {
            mat = Material.BEETROOT_SEEDS;
        } else if (roll < 50) {
            mat = Material.MELON_SEEDS;
        } else if (roll < 65) {
            mat = Material.PUMPKIN_SEEDS;
        } else if (roll < 80) {
            mat = Material.WHEAT_SEEDS;
        } else {
            mat = Material.STICK;
        }

        return new ItemStack(mat, 1);
    }

    private static void detonateBlocks(Location centre) {
        int centreX = centre.getBlockX();
        int centreY = centre.getBlockY();
        int centreZ = centre.getBlockZ();

        World world = centre.getWorld();

        for (int x = centreX - 1; x <= centreX + 1; x++) {
            for (int y = centreY - 1; y <= centreY + 1; y++) {
                for (int z = centreZ - 1; z <= centreZ + 1; z++) {
                    if (x == centreX && y == centreY && z == centreZ) continue;

                    Location loc = new Location(world, x, y, z);

                    Block block = loc.getBlock();
                    Material blockType = block.getType();

                    if (shovelBlocks.contains(blockType)) {
                        block.setType(Material.AIR);
                        world.dropItemNaturally(loc, new ItemStack(blockType, 1));
                    }
                }
            }
        }
    }
}
