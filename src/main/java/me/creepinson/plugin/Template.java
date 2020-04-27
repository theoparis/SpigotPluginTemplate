package me.creepinson.plugin;

import me.creepinson.plugin.command.ExampleCommand;
import me.creepinson.plugin.listener.ExampleListener;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Creepinson101
 * <p>
 * This is a Spigot Template for complete beginners. Feel free to use it
 * in any of your plugins! This template includes a few utilities made
 * both by me, and some other programmers out there.
 */
public class Template extends JavaPlugin {

    // Feel free to change this to your own plugin's name and color of your choice.
    public static final String CHAT_PREFIX = ChatColor.AQUA + "Template Plugin";

    private static Template plugin; // This is a static plugin instance that is private. Use getPlugin() as seen
    // further below.

    PluginDescriptionFile pdfFile; // plugin.yml

    public void onDisable() {
        plugin = getPlugin(Template.class);
        this.pdfFile = getDescription();

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
        /*
         * Register a command to the list of usable commands. If you don't register the
         * command, it won't work! Also if you change the command name, make sure to
         * also change in the plugin.yml file.
         */
        this.getCommand("example").setExecutor(new ExampleCommand());

        /*
         * Make sure you register your listeners if you have any! If you have a class
         * that implements Listener, you need to make sure to register it. Otherwise it
         * will DO NOTHING!
         */
        pm.registerEvents(new ExampleListener(), this);

        /*
         * This line lets you send out information to the console. In this case it would
         * say: Template-Plugin - Version 1.0.0 - has been enabled!
         */
        this.getLogger()
                .info(this.pdfFile.getName() + " - Version " + this.pdfFile.getVersion() + " - has been enabled!");
    }

}
