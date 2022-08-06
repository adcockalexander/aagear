package dczgear;

import dczgear.items.GearItem;
import dczgear.items.axes.fivestars.*;
import dczgear.items.axes.fourstars.*;
import dczgear.items.commands.fourstars.*;
import dczgear.items.commands.fivestars.*;
import dczgear.items.pickaxes.fivestars.*;
import dczgear.items.pickaxes.fourstars.*;
import dczgear.items.hoes.fivestars.*;
import dczgear.items.hoes.fourstars.*;
import dczgear.listeners.axes.*;
import dczgear.listeners.commands.CommandInteractListener;
import dczgear.listeners.hoes.*;
import dczgear.listeners.pickaxes.*;
import dczgear.utility.ItemCreator;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;
import java.util.logging.Level;

import static dczgear.utility.MessageUtility.message;

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
            Map.entry("AncientHarvester", new AncientHarvester()),
            Map.entry("CocoaSpreader", new CocoaSpreader()),
            Map.entry("PrototypeHatchet", new PrototypeHatchet()),
            Map.entry("SaplingSpitter", new SaplingSpitter()),
            Map.entry("EarthBlessing", new EarthBlessing()),
            Map.entry("PrimordialThresher", new PrimordialThresher()),
            Map.entry("EndlessCake", new EndlessCake()),
            Map.entry("ExperienceBinder", new ExperienceBinder()),
            Map.entry("HomingMarker", new HomingMarker()),
            Map.entry("LocksmithToolkit", new LocksmithToolkit()),
            Map.entry("MiniatureBlackhole", new MiniatureBlackhole()),
            Map.entry("MysticalClock", new MysticalClock()),
            Map.entry("OtherworldlyPortal", new OtherworldlyPortal()),
            Map.entry("SaplingOfKnowledge", new SaplingOfKnowledge()),
            Map.entry("ShapeshiftingHat", new ShapeshiftingHat()),
            Map.entry("SoulContract", new SoulContract()),
            Map.entry("TeleportationCrystal", new TeleportationCrystal()),
            Map.entry("AdvancedHomingMarker", new AdvancedHomingMarker()),
            Map.entry("EnchantedAnvil", new EnchantedAnvil()),
            Map.entry("FlightCatalyst", new FlightCatalyst()),
            Map.entry("SherlockSpyglass", new SherlockSpyglass()),
            Map.entry("SpeedCatalyst", new SpeedCatalyst())
    );

    @Override
    public void onEnable() {
        this.getLogger().info("DCZGear v" + VERSION_NUMBER + " - Starting Up");

        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            this.getLogger().log(Level.SEVERE, "Cannot initialise - missing Vault");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);

        if (rsp == null) {
            this.getLogger().log(Level.SEVERE, "Cannot initialise - missing Permission service provider");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        Permission perms = rsp.getProvider();

        getServer().getPluginManager().registerEvents(new PickaxeCraftListener(), this);
        getServer().getPluginManager().registerEvents(new PickaxeEffectListener(), this);
        getServer().getPluginManager().registerEvents(new HoeCraftListener(), this);
        getServer().getPluginManager().registerEvents(new HoeEffectListener(this), this);
        getServer().getPluginManager().registerEvents(new AxeCraftListener(), this);
        getServer().getPluginManager().registerEvents(new AxeEffectListener(this), this);
        getServer().getPluginManager().registerEvents(new CommandInteractListener(perms), this);
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

                    String senderName = sender.getName();

                    if (senderName.equals("CONSOLE")) {
                        message(ply, ChatColor.GREEN + "You received a " + args[2] + "!");
                    } else {
                        message(ply, ChatColor.GREEN + sender.getName() + " gave you a " + args[2] + "!");
                    }
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

}
