package me.creepinson.plugin.listener;

import me.creepinson.plugin.Template;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class ExampleListener implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		/*
		 * We get the player and make a variable to make it easier to access it when we
		 * need to use it.
		 */
		Player p = event.getPlayer();
		/*
		 * Here we cancel the event. This means that they can't break the block. In this
		 * case, we send a message to the player saying they don't have the required
		 * permission.
		 */
		if (!p.hasPermission("template.breakblocks")) {
			p.sendMessage(Template.CHAT_PREFIX +  ChatColor.WHITE + " > " + ChatColor.RED + "You do not have permission to break blocks!");
			event.setCancelled(true);
		}
	}

}
