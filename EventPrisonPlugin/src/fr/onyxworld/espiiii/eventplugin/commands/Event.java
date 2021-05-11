package fr.onyxworld.espiiii.eventplugin.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import fr.onyxworld.espiiii.eventplugin.type.EventType;
import fr.onyxworld.espiiii.eventplugin.type.Statut;
import net.md_5.bungee.api.ChatColor;

public class Event implements CommandExecutor
{
	// Declaration d'un eventStatut
	public static Statut eventStatut = null;
	
	// Declaration d'une liste d'Event
	public static ArrayList<EventType> eventList = EventType.getEventList();
	
	// Copie de l'auteur de la commande
	public static Player author = null;
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			
			// Verification d'un argument dans la commande /event []
			if(args.length == 0)
			{
				
				// Verification de la présence d'un event
				if(eventStatut == null) 
				{
				
					player.sendMessage(ChatColor.BLUE+"[OnyxEventInfo]: Aucun Event en cours");
					return true;
					
					
				}else
				{
					int playerWasParticipated = eventStatut.numberOfPlayer;
					String additionalArgs = eventStatut.additionalArgs;
					int type = eventStatut.type;
					
					player.sendMessage(ChatColor.YELLOW + "[OnyxEventInfo]: Event en cours : ");
					player.sendMessage(ChatColor.BLUE + "[OnyxEventInfo]: Type : "+ eventList.get(type).title);
					player.sendMessage(ChatColor.BLUE + "[OnyxEventInfo]: Description : " + eventList.get(type).description);
					switch(type) 
					{
					
					case 1 :
						
						player.sendMessage(ChatColor.GREEN+"[OnyxEventInfo]: Anagram : ");
						player.sendMessage(ChatColor.GREEN+"[OnyxEventInfo]: DefaultWord : ");
						
						break;
					
					case 2 :
						
						player.sendMessage(ChatColor.GREEN + "[OnyxEventInfo]: Question : ");
						player.sendMessage(ChatColor.GREEN + "[OnyxEventInfo]: Réponse : ");
						
						
					}
					player.sendMessage(ChatColor.BLUE + "[OnyxEventInfo]: Event en cours : ");
				}
				
			}
			
			//S'il y a d'autre arguments
			if(args.length >= 1)
			{
				
				// Test des arguments
				switch (args[0])
				{
				
				case "create" :
					
					if(args.length == 1)
					{	
						player.sendMessage(ChatColor.RED+"Il manques des arguments à la commande : "+ChatColor.AQUA+"/event create <type> <args>" + ChatColor.RED + ", /event list pour plus d'informations");
						return false;
					}
					
					switch (args[2])
					{
					
					case "anagram" :
						
						break;
					
					case "question" :
					
					}
					
					
					break;
					
				
				}
				
			}
			
		}
		if(sender instanceof ConsoleCommandSender)
		{
			System.out.println("This command not allowed to console");
			return true;
			
		}
		
		
		return false;
	}

	
	
}
