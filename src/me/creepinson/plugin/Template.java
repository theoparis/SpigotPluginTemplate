package me.creepinson.plugin;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.creepinson.plugin.command.ExampleCommand;
import net.md_5.bungee.api.ChatColor;

public class Template extends JavaPlugin {

	// Feel free to change this to your own plugin's name and color of your choice.
	public static final String CHAT_PREFIX = ChatColor.AQUA + "Template Plugin" + ChatColor.GRAY + " > ";
	
	private static Template plugin; // static plugin instance
	
	PluginDescriptionFile pdfFile; // plugin.yml

	public void onDisable() {
		plugin = getPlugin(Template.class);
		this.pdfFile = getDescription();
		this.getLogger()
				.info(this.pdfFile.getName() + " Version: " + this.pdfFile.getVersion() + " has been disabled!");

		
	}

	public static Template getPlugin() { // getter for the static plugin instance
		return plugin;
	}

	public PluginDescriptionFile getPdfFile() {
		return pdfFile;
	}

	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		this.pdfFile = getDescription();
		this.getLogger().info(this.pdfFile.getName() + " Version: " + this.pdfFile.getVersion() + " has been enabled!");

		// register command
		this.getCommand("example").setExecutor(new ExampleCommand());
		
	}

}
