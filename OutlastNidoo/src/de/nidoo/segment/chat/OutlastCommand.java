package de.nidoo.segment.chat;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class OutlastCommand implements CommandExecutor {
	 

	@Override
	public boolean onCommand(CommandSender commandSender, Command arg1, String arg2, String[] arg3) {
		Player player = (Player) commandSender;
        player.sendMessage("§8[§2§lOUTLAST§8] §7 Hier siehst du bald Hilfen.");
		return false;
	}
}

