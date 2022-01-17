package de.nidoo.segment.dailyrewards;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import de.nidoo.segment.economy.Economy;
import de.nidoo.segment.main.Main;

/**
 * Created by Lonzbonz on 09.03.2015
 */
public class RewardCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(Main.getInstance().prefix + "§cDu musst ein Spieler sein!");
			return true;
		}
		Player p = (Player) sender;
		if(args.length == 0) {
			if(!Main.getInstance().rewardManager.getAllowReward(p)) {
				p.sendMessage(Main.getInstance().prefix + "§cDu hast deinen Lohn heute bereits abgeholt!");
				long current = System.currentTimeMillis();
				long release = Main.getInstance().rewardManager.getTime(p);
				long millis = release - current;
				p.sendMessage(Main.getInstance().prefix + Main.getInstance().rewardManager.getRemainingTime(millis));
				return true;
			}
			p.sendMessage(Main.getInstance().prefix + "§7Du hast §a+500 §7erhalten!");
		      Economy.addMoney(p,500);
		      Main.getInstance().rewardManager.setReward(p);
		      //scoreboard
          	Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
      		Objective objective = board.registerNewObjective("abcd", "abcd");
      	    objective.setDisplaySlot(DisplaySlot.SIDEBAR);
      	    objective.setDisplayName("§2§lOUTLAST");
      	    objective.getScore("§7 23/11/2021 ").setScore(9);
      	    objective.getScore("§b ").setScore(9);
      	    objective.getScore("§b ").setScore(8);
      	    objective.getScore("§8▐ §6Konto").setScore(7);
      	    objective.getScore("§e ➥ " + p.getName()).setScore(6);
      	    objective.getScore("§b").setScore(5);
      	    objective.getScore("§8▐ §2Coins").setScore(4);
      	    objective.getScore("§a ➥ " + Economy.getMoney(p)).setScore(3);
      	    objective.getScore("§6").setScore(2);
      	    objective.getScore("§enidoo.play-mc.de").setScore(1);
      	    p.setScoreboard(board);
      	    //scoreboard
			if(Main.getInstance().broadcast) {
				Bukkit.broadcastMessage(Main.getInstance().prefix + "§l§8" + p.getName() + " §r§7hat seine Taeglische Belohnung abgeholt.");
			}
			return true;
		}
		p.sendMessage(Main.getInstance().prefix + "§c/reward");
		return true;
	
	}

}
