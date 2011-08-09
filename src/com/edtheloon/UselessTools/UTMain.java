package com.edtheloon.UselessTools;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class UTMain extends JavaPlugin {

	public static configHandler config;
	public static Logger log = Logger.getLogger("minecraft");
	public PluginManager pm = this.getServer().getPluginManager();

	public void onEnable() {
		config = new configHandler(this);
		pm.registerEvent(Type.PLAYER_INTERACT, new UTServerListener(), Priority.Highest, this);
		log.info("[UselessTools] Version " + this.getDescription().getVersion() + " enabled.");
	}

	public void onDisable() {
		log.info("[UselessTools] Version " + this.getDescription().getVersion() + " disabled.");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		if (args[0].equalsIgnoreCase("reload"))
		{
			if (sender.isOp() || sender instanceof ConsoleCommandSender)
			{
				config.loadConfig();
				sender.sendMessage(ChatColor.GREEN + "[UselessTools] Configuration reloaded");
			}
		}
		if (args[0].equalsIgnoreCase("disable"))
		{
			if(sender.isOp() || sender instanceof ConsoleCommandSender)
			{
				this.getPluginLoader().disablePlugin(this);
			}
		}
		return true;
	}
}
