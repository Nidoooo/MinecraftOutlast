package de.nidoo.segment.dailyrewards;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import de.nidoo.segment.main.Main;

public class RewardManager {
	
	private Main instance;
	
	public RewardManager(Main instance) {
		this.instance = instance;
	}
	
	public boolean getAllowReward(Player player) {
		long current = System.currentTimeMillis();
		long millis = getTime(player);
		return current > millis;
	}
	
	public File getRewardFile() {
		return new File(instance.getDataFolder(), "rewards.yml");
	}
	
	public void setReward(Player player) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getRewardFile());
		long toSet = System.currentTimeMillis()+43200000; //86400000  //43200000
		cfg.set(player.getUniqueId() + ".millis", toSet);
		try {
			cfg.save(getRewardFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(String command : YamlConfiguration.loadConfiguration(FileManager.getConfigFile()).getStringList("rewardCommands")) {
			command = command.replace("%player%", player.getName());
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
		}
	}
	
	public long getTime(Player player) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(getRewardFile());		
		return cfg.getLong(player.getUniqueId() + ".millis");
	}
	
	public String getRemainingTime(long millis) {
		long seconds = millis/1000;
		long minutes = 0;
		while(seconds > 60) {
			seconds-=60;
			minutes++;
		}
		long hours = 0;
		while(minutes > 60) {
			minutes-=60;
			hours++;
		}
		return "§7" + hours + " Stunde(n) " + minutes + " Minute(n) " + seconds + " Sekunde(n)";
	}
}
