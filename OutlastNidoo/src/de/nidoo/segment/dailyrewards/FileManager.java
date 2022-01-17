package de.nidoo.segment.dailyrewards;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.nidoo.segment.main.Main;

/**
 * Created by Lonzbonz on 09.03.2015
 */
public class FileManager {
	
	public static File getConfigFile() {
		return new File(Main.getInstance().getDataFolder(), "config.yml");
	}
	
	public static void setDefault() {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getConfigFile());
		cfg.options().copyDefaults(true);
		cfg.addDefault("prefix", "&8[&5Belohnung&8]");
		cfg.addDefault("broadcast", true);
		List<String> commands = new ArrayList<String>();
		cfg.addDefault("rewardCommands", commands);
		try {
			cfg.save(getConfigFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadConfig() {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getConfigFile());
		Main.getInstance().prefix = ChatColor.translateAlternateColorCodes('&', cfg.getString("prefix")) + " §r";
		Main.getInstance().broadcast = cfg.getBoolean("broadcast");
	}

}
