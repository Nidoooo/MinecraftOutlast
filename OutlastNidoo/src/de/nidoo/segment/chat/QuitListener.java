package de.nidoo.segment.chat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener{

	@EventHandler
	public void handlePlayerQuit(PlayerQuitEvent event) {
		event.setQuitMessage("§8[§c<<§8] §7" + event.getPlayer().getName());
	   
	}
	
}

	


