package de.nidoo.segment.lobby;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import de.nidoo.segment.economy.Economy;

public class tablist implements Listener{
	
	
	
	@EventHandler
	public void handlePlayerJoin(PlayerJoinEvent event) {
		Player player= event.getPlayer();
		
	
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective objective = board.registerNewObjective("abcd", "abcd");
	    objective.setDisplaySlot(DisplaySlot.SIDEBAR);
	    objective.setDisplayName("§2§lOUTLAST");
	    objective.getScore("§7 23/11/2021 ").setScore(9);
	    objective.getScore("§b ").setScore(9);
	    objective.getScore("§b ").setScore(8);
	    objective.getScore("§8▐ §6Konto").setScore(7);
	    objective.getScore("§e ➥ " + player.getName()).setScore(6);
	    objective.getScore("§b").setScore(5);
	    objective.getScore("§8▐ §2Coins").setScore(4);
	    objective.getScore("§a ➥ " + Economy.getMoney(player)).setScore(3);
	    objective.getScore("§6").setScore(2);
	    objective.getScore("§enidoo.play-mc.de").setScore(1);
	    player.setScoreboard(board);
	
	}
}
