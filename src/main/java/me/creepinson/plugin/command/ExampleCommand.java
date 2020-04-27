package me.creepinson.plugin.command;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static me.creepinson.plugin.Template.CHAT_PREFIX;

// All command classes need to implement the CommandExecutor interface to be a proper command!
public class ExampleCommand implements CommandExecutor {

    /* Called when the command is ran
    args variable is the commands arguments in an array of strings.
    sender variable is the sender who ran the command
    */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {

		/* Checks if the sender is sending from the console
		   CHAT_PREFIX is the variable from the Template plugin class and can be removed
		   if unwanted. 
		*/
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage(CHAT_PREFIX + ChatColor.WHITE + " > " + ChatColor.RED + "You cannot run this command from the console!");
            return false;
        }
        /*
         * Since we made sure the sender is a player, we can create a new player
         * variable using our sender
         */
        Player player = (Player) sender;

        // checks if there are no arguments at all (/command)
        if (args.length == 0) {
            player.sendMessage(CHAT_PREFIX + ChatColor.WHITE + " > " + ChatColor.RED + "Invalid usage - there are no arguments.");
            return false;
        }

        /*
         * checks if First argument (/command FIRSTARGUMENT) is equal to the string In
         * this case, the command would be: /example sayhi
         */
        if (args[0].equalsIgnoreCase("sayhi")) {

            /*
             * makes the player chat the message, Hello Everyone! colored light green.
             */
            player.chat(ChatColor.GREEN + "Hello Everyone!");

            return true;
        } else {
            player.sendMessage(CHAT_PREFIX + ChatColor.WHITE + " > " + ChatColor.RED + "Invalid usage or arguments.");
            return false;
        }
    }

}
