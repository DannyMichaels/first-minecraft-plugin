package com.daniel.firstplugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
	// when the plugin is ran for first time it will run this block of code.
		
	  System.out.println("PLUGIN ENABLED!");
	}

	@Override
	public void onDisable() {
	  System.out.println("PLUGIN DISABLED!");
	}
	
	//  onCommand is a method that runs when any player runs ANY command (even if it doesn't exist.) EX: /hello
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	  String commandName = cmd.getName();
	  Player player = verifyPlayer(sender);

	  if (player == null) return false;
			  
	  switch(commandName) {
	    case "recover": 
		  healPlayer(player);
			
	    case "reverse_name":
		    printPlayerNameReversed(player);
		  
		 default: 
			break;
	  }
	  
	  return false;
	}
	

	public Player verifyPlayer(CommandSender sender) {
		if (sender instanceof Player) {
		  Player player = (Player) sender;
		  return player;
		}
		
		System.out.println("You cannot use this console through console");
		return null;
	}
	
	public void healPlayer(Player playerToBeHealed) {
	  playerToBeHealed.sendMessage(
			  ChatColor.GRAY + "Hello, " + ChatColor.GREEN + playerToBeHealed.getName() + 
			  ChatColor.GRAY + ". Your health has been restored"
	   );
	
	  playerToBeHealed.setHealth(20.0);
	}
	
	public void printPlayerNameReversed(Player player) {
	  String reversedPlayerName = new StringBuilder(player.getName()).reverse().toString();
	  player.sendMessage(reversedPlayerName);
	}
}
