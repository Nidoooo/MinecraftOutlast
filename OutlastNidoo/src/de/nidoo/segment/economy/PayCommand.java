package de.nidoo.segment.economy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
 
public class PayCommand implements CommandExecutor {
 
 
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
 
        if(commandSender instanceof Player) {
 
            Player player = (Player) commandSender;

 
                if(strings.length == 2) {
 
                    Player target = Bukkit.getPlayer(strings[0]);
                    int amount = Integer.parseInt(strings[1]);
 
                    if(Economy.getMoney(player) >= amount) {
 
                        Economy.removeMoney(player, amount);
                        Economy.addMoney(target, amount);
                        

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
                	    
                	    Scoreboard board1 = Bukkit.getScoreboardManager().getNewScoreboard();
                		Objective objective1 = board1.registerNewObjective("abcd", "abcd");
                	    objective1.setDisplaySlot(DisplaySlot.SIDEBAR);
                	    objective1.setDisplayName("§2§lOUTLAST");
                	    objective1.getScore("§7 23/11/2021 ").setScore(9);
                	    objective1.getScore("§b ").setScore(9);
                	    objective1.getScore("§b ").setScore(8);
                	    objective1.getScore("§8▐ §6Konto").setScore(7);
                	    objective1.getScore("§e ➥ " + target.getName()).setScore(6);
                	    objective1.getScore("§b").setScore(5);
                	    objective1.getScore("§8▐ §2Coins").setScore(4);
                	    objective1.getScore("§a ➥ " + Economy.getMoney(target)).setScore(3);
                	    objective1.getScore("§6").setScore(2);
                	    objective1.getScore("§enidoo.play-mc.de").setScore(1);
                	    target.setScoreboard(board1);
                	    
                	   

 
                        player.sendMessage("§8[§2ⓒ§8] §7" + "Du" + " §8→§a "+amount+ " §8→§7 " + target.getName());
                        target.sendMessage("§8[§2ⓒ§8] §7" + player.getName() + " §8→§a "+amount+ " §8→§7 " + "Dir");
 
                    } else
                        player.sendMessage("§8[§e!§8] §c" +"§cDazu hast du nicht genug Geld.");
 
                } else
                    player.sendMessage("§8[§e!§8] §c" +"§cBitte benutze §6/pay <NAME> <AMOUNT>");

       
    }return false;
    }
}
 