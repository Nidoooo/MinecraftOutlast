package de.nidoo.segment.chat;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class OutlastHelpCommand implements CommandExecutor {
	 

	@Override
	public boolean onCommand(CommandSender commandSender, Command arg1, String arg2, String[] arg3) {
		Player player = (Player) commandSender;
        player.sendMessage("§8[§6§lHILFE§8] §7 Ist in arbeit.");
		return false;
	}
}

