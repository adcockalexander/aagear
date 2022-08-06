package dczgear.listeners.commands;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;

import static dczgear.utility.MessageUtility.message;

public class CommandInteractListener implements Listener {

    private final Permission perms;

    public CommandInteractListener(Permission perms) {
        this.perms = perms;
    }

    private static final Map<String, List<String>> permissionMap = Map.ofEntries(
            Map.entry(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Endless Cake",
                    List.of("essentials.feed true", "essentials.heal true")),
            Map.entry(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Experience Binder",
                    List.of("essentials.keepxp true")),
            Map.entry(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Homing Marker",
                    List.of("essentials.sethome.multiple true", "essentials.sethome.multiple.five true")),
            Map.entry(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Miniature Blackhole",
                    List.of("essentials.condense true")),
            Map.entry(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Mystical Clock",
                    List.of("essentials.ptime true")),
            Map.entry(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Otherworldly Portal",
                    List.of("essentials.warp true", "essentials.warp.list true")),
            Map.entry(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Portable Anvil",
                    List.of("essentials.repair true")),
            Map.entry(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Sapling of Knowledge",
                    List.of("mcmmo.perks.xp.double true", "mcmmo.perks.xp.double.* true")),
            Map.entry(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Shapeshifting Hat",
                    List.of("essentials.hat true")),
            Map.entry(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Soul Contract",
                    List.of("essentials.keepinv true world=world", "essentials.keepinv true world=world_nether",
                            "essentials.keepinv true world=world_the_end")),
            Map.entry(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Teleportation Crystal",
                    List.of("essentials.tpa true", "essentials.tpahere true")),
            Map.entry(ChatColor.GOLD + "" + ChatColor.BOLD + "Advanced Homing Marker",
                    List.of("essentials.sethome.multiple.fifty true")),
            Map.entry(ChatColor.GOLD + "" + ChatColor.BOLD + "Enchanted Anvil",
                    List.of("essentials.repair.all true", "essentials.commandcooldowns.bypass true")),
            Map.entry(ChatColor.GOLD + "" + ChatColor.BOLD + "Flight Catalyst",
                    List.of("essentials.fly true", "essentials.fly.safelogin true")),
            Map.entry(ChatColor.GOLD + "" + ChatColor.BOLD + "Sherlock's Spyglass",
                    List.of("essentials.vanish true world=world", "essentials.vanish true world=world_nether",
                            "essentials.vanish true world=world_the_end", "coreprotect.co true",
                            "coreprotect.core true", "coreprotect.inspect true")),
            Map.entry(ChatColor.GOLD + "" + ChatColor.BOLD + "Speed Catalyst",
                    List.of("essentials.speed true", "essentials.speed.fly true", "essentials.speed.walk true"))
    );

    private static final Map<String, String> groupMap = Map.ofEntries(
            Map.entry(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Locksmith's Toolkit",
                    "unlimited")
    );

    private static final Map<String, String> requiredPermissionMap = Map.ofEntries(
            Map.entry(ChatColor.GOLD + "" + ChatColor.BOLD + "Advanced Homing Marker", "essentials.sethome.multiple.five"),
            Map.entry(ChatColor.GOLD + "" + ChatColor.BOLD + "Enchanted Anvil", "essentials.repair")
    );

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player ply = event.getPlayer();
        ItemStack item = event.getItem();

        if (item == null) return;

        ItemMeta itemMeta = item.getItemMeta();

        if (itemMeta == null) return;

        String itemName = itemMeta.getDisplayName();

        if (permissionMap.get(itemName) != null) {
            event.setCancelled(true);

            if (requiredPermissionMap.get(itemName) != null) {
                if (!ply.hasPermission(requiredPermissionMap.get(itemName))) {
                    message(ply, ChatColor.RED + "You do not meet the requirements to unlock this!");
                    return;
                }
            }

            List<String> permissions = permissionMap.get(itemName);

            boolean missingPermission = false;

            for (String permission : permissions) {
                // Take the first word from the permission string
                if (!ply.hasPermission(permission.substring(0, permission.indexOf(' ')))) {
                    missingPermission = true;
                    break;
                }
            }

            if (!missingPermission) {
                message(ply, ChatColor.RED + "You have already unlocked this!");
                return;
            }

            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

            for (String permission : permissions) {
                Bukkit.dispatchCommand(console, "lp user " + ply.getName() + " permission set " + permission);
            }

            item.setAmount(item.getAmount() - 1);

            for (Player onlinePly : Bukkit.getServer().getOnlinePlayers()) {
                message(onlinePly, ChatColor.RED + ply.getName() + ChatColor.WHITE + " just redeemed a "
                + itemName + ChatColor.WHITE + "!");
            }

            message(ply, ChatColor.WHITE + "You redeemed a " + itemName + ChatColor.WHITE + "!");
        } else if (groupMap.get(itemName) != null) {
            event.setCancelled(true);

            if (requiredPermissionMap.get(itemName) != null) {
                if (!ply.hasPermission(requiredPermissionMap.get(itemName))) {
                    message(ply, ChatColor.RED + "You do not meet the requirements to unlock this!");
                    return;
                }
            }

            String group = groupMap.get(itemName);

            if (perms.playerInGroup(ply, group)) {
                message(ply, ChatColor.RED + "You have already unlocked this!");
                return;
            }

            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            Bukkit.dispatchCommand(console, "lp user " + ply.getName() + " parent add " + group);

            item.setAmount(item.getAmount() - 1);

            for (Player onlinePly : Bukkit.getServer().getOnlinePlayers()) {
                message(onlinePly, ChatColor.RED + ply.getName() + ChatColor.WHITE + " just redeemed a "
                        + itemName + ChatColor.WHITE + "!");
            }

            message(ply, ChatColor.WHITE + "You redeemed a " + itemName + ChatColor.WHITE + "!");
        }
    }
}
