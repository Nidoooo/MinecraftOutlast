package de.nidoo.segment.chat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class bugblog implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender commandSender, Command arg1, String arg2, String[] arg3) {
		Player player = (Player) commandSender;
        player.sendMessage("§8[§2§lOUTLAST§6§lBUG§e§lBLOG§8] §f§n Der SpiriError §8[16:12 14.11.2021]");
        player.sendMessage("§7 Der Fehler ist ganz einfach zu erklären. Dardurch das Nidoo den Server auf gecracked gestellt hatte das Spiridon drauf kommt. Hat der Server von sich aus eine Überprüfung gestartet, die jede Sekunde rund 50 Mal Testet ob der Server (z.b Tizian_) ein Echter Spieler ist oder ein gecracketer Spieler, dies hat für Emense Lags geführt so das der Server auf 549% über der Maximalauslaustung war. Nach dem Nidoo dann draf war wurde es dem Server zuviel, bei 50 testes pro sekunde bei 4 Spieler erklärt es sich ja.");
		return false;
	}
}




