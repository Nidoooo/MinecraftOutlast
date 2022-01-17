package de.nidoo.segment.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.nidoo.segment.chat.DeathListener;
import de.nidoo.segment.chat.JoinListener;
import de.nidoo.segment.chat.OutlastCommand;
import de.nidoo.segment.chat.OutlastHelpCommand;
import de.nidoo.segment.chat.QuitListener;
import de.nidoo.segment.chat.bugblog;
import de.nidoo.segment.economy.MoneyCommand;
import de.nidoo.segment.economy.PayCommand;
import de.nidoo.segment.economy.SetCommand;
import de.nidoo.segment.lobby.tablist;
import de.nidoo.segment.dailyrewards.FileManager;
import de.nidoo.segment.dailyrewards.RewardCommand;
import de.nidoo.segment.dailyrewards.RewardManager;


public class Main extends JavaPlugin {

	


	private static Main plugin;
	@Override
	public void onEnable() {
		
		instance = this;
		FileManager.setDefault();
		FileManager.loadConfig();
		this.rewardManager = new RewardManager(this);
		this.getCommand("lohn").setExecutor(new RewardCommand());
		Bukkit.getConsoleSender().sendMessage(prefix + "§aPlugin version: " + this.getDescription().getVersion() + " by Nidoo enabled!");
		
		
		 plugin = this;

	        System.out.println("[CoinSystem] Plugin gestartet.");
 

	        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);

	        getCommand("konto").setExecutor(new MoneyCommand());
	        getCommand("gib").setExecutor(new PayCommand());
	        getCommand("setmoney").setExecutor(new SetCommand());
	        getCommand("outlast").setExecutor(new OutlastCommand());
	        getCommand("hilfe").setExecutor(new OutlastHelpCommand());
	        getCommand("bugblog").setExecutor(new bugblog());
	        
	        PluginManager pluginManager = Bukkit.getPluginManager();
			pluginManager.registerEvents(new JoinListener(), this);
			pluginManager.registerEvents(new QuitListener(), this);
			pluginManager.registerEvents(new DeathListener(), this);
			pluginManager.registerEvents(new tablist(), this);
			
			


	}
	
	
			public String prefix = "";
			public static Main instance;
			public RewardManager rewardManager;
			public boolean broadcast;
			
			public static Main getInstance() {
				return instance;
			
	    }
			

	 public static Main getPlugin() {
	        return plugin;
	    }}

	 
	

	
 	
