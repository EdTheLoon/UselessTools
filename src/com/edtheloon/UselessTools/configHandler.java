package com.edtheloon.UselessTools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.config.Configuration;

public class configHandler {
	
	// Configuration file properties
	private Plugin plugin;
	private File configFile = new File("plugins/UselessTools" + File.separator + "config.yml"); // Be sure to change the file this points to
	private Configuration config;
	
	// Config nodes and default variables
	public List<Integer> tools;
	
	// CONSTRUCTOR 
	public configHandler(Plugin _plugin) {
		this.plugin = _plugin;
		this.config = new Configuration(configFile);
		
		// If config exists then load it. Otherwise create a config
		if (checkConfig()) {
			loadConfig();
		} else {
			createConfig();
		}
	}
	
	// Check to see if config exists, returns true or false
	public boolean checkConfig() {
		if (!configFile.exists())
		{
			return false;
		} else {
			return true;
		}
	}
	
	// Create the configuration file and insert default values
	public void createConfig() {
		
		// Create a default list - this list contains the IDs of all gold tools
		tools = new ArrayList<Integer>();
		tools.add(283);
		tools.add(284);
		tools.add(285);
		tools.add(286);
		tools.add(294);
		
		// Add the list to the tools property
		config.setProperty("tools", tools);
		// Set a header
		config.setHeader("# UselessTools Version " + plugin.getDescription().getVersion());
		// Finally, save the config to file
		config.save();
		
		// Now that the config is created we can load the values
		loadConfig();
	}
	
	// Load configuration file
	public void loadConfig() {		
		config.load();		
		tools = config.getIntList("tools", null);		
	}
}
