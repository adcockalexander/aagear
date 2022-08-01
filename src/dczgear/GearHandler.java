package dczgear;

import dczgear.items.GearItem;
import dczgear.items.pickaxes.fivestars.*;
import dczgear.items.pickaxes.fourstars.*;
import dczgear.items.hoes.fivestars.*;
import dczgear.items.hoes.fourstars.*;
import dczgear.listeners.hoes.HoeCraftListener;
import dczgear.listeners.hoes.HoeEffectListener;
import dczgear.listeners.pickaxes.*;
import dczgear.utility.ItemCreator;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;

public class GearHandler extends JavaPlugin {

    private static final String VERSION_NUMBER = "1.0";

    // Add any items you want obtainable through '/gear give' to this map
    private static final Map<String, GearItem> gearMap = Map.ofEntries(
            Map.entry("CrystalDriver", new CrystalDriver()),
            Map.entry("VolcanicShard", new VolcanicShard()),
            Map.entry("SkywardFragment", new SkywardFragment()),
            Map.entry("MasterPride", new MasterPride()),
            Map.entry("DragonTooth", new DragonTooth()),
            Map.entry("FarmerTrick", new FarmerTrick()),
            Map.entry("RootTrimmer", new RootTrimmer()),
            Map.entry("AncientHarvester", new AncientHarvester())
    );

    @Override
    public void onEnable() {
        this.getLogger().info("DCZGear v" + VERSION_NUMBER + " - Starting Up");

        getServer().getPluginManager().registerEvents(new PickaxeCraftListener(), this);
        getServer().getPluginManager().registerEvents(new PickaxeEffectListener(), this);
        getServer().getPluginManager().registerEvents(new HoeCraftListener(), this);
        getServer().getPluginManager().registerEvents(new HoeEffectListener(this), this);
    }

    @Override
    public void onDisable() {
        this.getLogger().info("DCZGear v" + VERSION_NUMBER + " - Shutting Down");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("gear")) {
            if (args.length == 3) {
                if (args[0].equals("give")) {
                    if (!sender.hasPermission("dczgear.give")) {
                        message(sender, ChatColor.RED + "No permission!");
                        return true;
                    }

                    Player ply = Bukkit.getPlayer(args[1]);

                    if (ply == null) {
                        message(sender, ChatColor.RED + "Couldn't find player " + args[1] + "!");
                        return true;
                    }

                    GearItem gear = gearMap.get(args[2]);

                    if (gear == null) {
                        message(sender, ChatColor.RED + "No gear item found with ID: " + args[2]);
                        return true;
                    }

                    Material mat = gear.getBaseMaterial();

                    if (mat == Material.BARRIER) {
                        message(sender, ChatColor.RED + "Gear item not properly configured (base material not set)");
                        return true;
                    }

                    ItemStack item = ItemCreator.createItemFromGear(gear, mat);

                    ply.getInventory().addItem(item);

                    message(sender, ChatColor.GREEN + "Successfully gave " + args[1] + " a " + args[2] + "!");
                    message(ply, ChatColor.GREEN + sender.getName() + " gave you a " + args[2] + "!");
                } else {
                    message(sender, ChatColor.RED + "Bad arguments!");
                }

            } else {
                message(sender, ChatColor.RED + "Bad arguments!");
            }
            return true;
        }

        return false;
    }

    private void message(CommandSender ply, String message) {
        ply.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Gear " + ChatColor.DARK_GRAY + ChatColor.BOLD +
                ">> " + ChatColor.RESET + message);
    }
}
