package aagear.utility;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;

public class MessageUtility {

    // Simple helper function to send a formatted message to a CommandSender.
    public static void message(CommandSender ply, String message) {
        ply.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Gear " + ChatColor.DARK_GRAY + ChatColor.BOLD +
                ">> " + ChatColor.RESET + message);
    }

}
