package de.nidoo.segment.economy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class MoneyCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player) {

            Player p = (Player) commandSender;
        
            Player player = (Player) commandSender;

                if(strings.length == 0) {


                	p.sendMessage("§8[§2ⓒ§7"+player.getName()+"§8]§a " + Economy.getMoney(p));


                } else if(strings.length == 1) {

                    Player target = Bukkit.getPlayer(strings[0]);

                    if(target != null) {


                    	p.sendMessage("§8[§2ⓒ§7"+target.getName()+"§8]"+"§a " + Economy.getMoney(target));

                    	
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
                	    

                    } else
                        p.sendMessage("§8[§e!§8] §c" +"§cDieser Spieler ist nicht auf dem Server!");

                } else
                    p.sendMessage("§8[§e!§8] §c" +"§cBitte benutze §6/money [name]§c!");

        } else
            commandSender.sendMessage("§8[§e!§8] §c" +"§cDazu musst du ein Spieler sein!");
    

    

    return false;
    }

}
