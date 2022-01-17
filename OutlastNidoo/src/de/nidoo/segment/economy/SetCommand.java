package de.nidoo.segment.economy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
 
public class SetCommand implements CommandExecutor {
 
 
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
 
        if(commandSender instanceof Player) {
 
            Player player = (Player) commandSender;
 
            if(player.hasPermission("Coins.pay")) {
 
                if(strings.length == 2) {
 
                    Player target = Bukkit.getPlayer(strings[0]);
                    int amount = Integer.parseInt(strings[1]);
 
                    Economy.setMoney(target, amount);
                    player.sendMessage("§8[§2ⓒ§8] §7" + "Du die Coins von §e" + target.getName() + "§7 auf §a" + amount + "§7 gesetzt.");

                	Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
            		Objective objective = board.registerNewObjective("abcd", "abcd");
            	    objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            	    objective.setDisplayName("§2§lOUTLAST");
            	    objective.getScore("§7 23/11/2021 ").setScore(9);
            	    objective.getScore("§b ").setScore(9);
            	    objective.getScore("§b ").setScore(8);
            	    objective.getScore("§8▐ §6Konto").setScore(7);
            	    objective.getScore("§e ➥ " + target.getName()).setScore(6);
            	    objective.getScore("§b").setScore(5);
            	    objective.getScore("§8▐ §2Coins").setScore(4);
            	    objective.getScore("§a ➥ " + Economy.getMoney(target)).setScore(3);
            	    objective.getScore("§6").setScore(2);
            	    objective.getScore("§enidoo.play-mc.de").setScore(1);
            	    target.setScoreboard(board);


 
                    } else
                        player.sendMessage("§8[§e!§8] "+ "§cDazu hast du nicht genug Geld.");
 
                } else
                    player.sendMessage("§8[§e!§8] "+ "§cBitte benutze §6/setmoney <NAME> <AMOUNT>");
 
 
            }
   
 
        return false;
    }
}

