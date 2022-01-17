package de.nidoo.segment.chat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


;
public class JoinListener implements Listener{
	 
	@EventHandler
	public void handlePlayerJoin(PlayerJoinEvent event) {
		@SuppressWarnings("unused")
		Player player= event.getPlayer();
		event.setJoinMessage("§8[§2>>§8] §7" + event.getPlayer().getName());
	
	    }
}
