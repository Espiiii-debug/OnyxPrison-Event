package fr.onyxworld.espiiii.eventplugin;

import org.bukkit.plugin.java.JavaPlugin;

import fr.onyxworld.espiiii.eventplugin.commands.Event;

public class Main extends JavaPlugin 
{
	
	// Lorsque le plugin est activé
	@Override
	public void onEnable()
	{
		
		System.out.println("--------------------");
		System.out.println("| OnyxPrison Event |");
		System.out.println("--------------------");
		
		
		// Register command "event"
		this.getCommand("event").setExecutor(new Event());
		
		super.onEnable();
	}
	
	// Lorsque le serveur s'eteint
	@Override
	public void onDisable() 
	{
	
		
		
		super.onDisable();
	}

}
