package fr.onyxworld.espiiii.eventplugin.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import fr.onyxworld.espiiii.eventplugin.events.Anagram;
import fr.onyxworld.espiiii.eventplugin.type.EventType;
import fr.onyxworld.espiiii.eventplugin.type.Statut;


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
				
				// Si l'argument est create (/event create)
				case "create" :
					
					// S'il manque des arguments
					if(args.length == 1)
					{	
						player.sendMessage(ChatColor.RED+"[OnyxEventInfo]:Il manques des arguments à la commande : "+ChatColor.AQUA+"/event create <type> <args>" + ChatColor.RED + ", /event list pour plus d'informations");
						return false;
					}
					// Sinon,
					switch (args[2])
					{
					
					// Si l'event choisi est anagram
					case "anagram" :
						if(args.length != 3)
						{
							player.sendMessage(ChatColor.RED+"[OnyxEventInfo]: Merci de respecter la syntaxe de la commande : "+ChatColor.AQUA+"/event create anagram <word>");
							return false;
						}else 
						{
							String defaultWord = args[3];
							String anagram = Anagram.randomLetters(defaultWord);
							Bukkit.getServer().broadcastMessage(ChatColor.BLUE+"[OnyxEventInfo]: Bonjour, un event à été lancé, pour participer, il vous suffit d'écrire la réponse dans le chat.");
							Bukkit.getServer().broadcastMessage(ChatColor.BLUE+"[OnyxEventInfo]: --");
							Bukkit.getServer().broadcastMessage(ChatColor.BLUE+"[OnyxEventInfo]: Le principe est simple : Vous devrez trouver l'annagrame de " + ChatColor.YELLOW + anagram );
							Bukkit.getServer().broadcastMessage(ChatColor.BLUE+"[OnyxEventInfo]: Qu'est-ce qu'un Annagrame ? C'est simple un annagrame est un où toutes les lettres ont été mises dans le désordre");
							Bukkit.getServer().broadcastMessage(ChatColor.BLUE+"[OnyxEventInfo]: Exemple : "+ ChatColor.AQUA +"snPiro" + ChatColor.BLUE + " est l'anagram de "+ChatColor.AQUA+"Prison");
							Bukkit.getServer().broadcastMessage(ChatColor.BLUE+"[OnyxEventInfo]: Vous n'avez le droit qu'a une seule participation, bonne chance !");


							
						}
						break;
					
					// Si l'event choisi est question 
					case "question" :
						if(args.length != 4)
						{
							player.sendMessage(ChatColor.RED+"[OnyxEventInfo]: Merci de respecter la syntaxe de la commande : "+ChatColor.AQUA+"/event create question <question> <answer>");
							return false;
						}
						
						break;
					
					}
					break;
					
				// si l'argument est stop (/event stop)
				case "stop":
					
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
