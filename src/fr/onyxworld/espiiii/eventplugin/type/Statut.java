package fr.onyxworld.espiiii.eventplugin.type;

public class Statut 
{
	
	// Type d'event
	public int type;
	
	// Nombre de joueurs ayant participé
	public int numberOfPlayer;
	
	// Arguments supplémentaires
	public String additionalArgs;
		
	public Statut(int type, int numberOfPlayer, String additionalArgs)
	{
		
		this.type = type;
		this.numberOfPlayer = numberOfPlayer;
		this.additionalArgs = additionalArgs;
		
	}
	
	
	
}
