package de.nidoo.segment.chat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


public class DeathListener implements Listener{
	
	@EventHandler
	public void onEDeath(PlayerDeathEvent e) {
	    if (e.getEntity().getKiller() != null) {
	        Player player = (Player) e.getEntity();
	        Player player2 = e.getEntity().getKiller();
	        Bukkit.broadcastMessage("§8[§4✘§8] §7§m" + player.getName() +"§r"+ "§f ⚔ §7" + player2.getName());
	} else {
	    Player player = (Player) e.getEntity();
	    Bukkit.broadcastMessage("§8[§4✘§8] §7" + player.getName());
	}

	}
}
