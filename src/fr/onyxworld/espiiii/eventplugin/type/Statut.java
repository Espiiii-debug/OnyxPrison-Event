package fr.onyxworld.espiiii.eventplugin.type;

public class Statut 
{
	
	// Type d'event
	public int type;
	
	// Nombre de joueurs ayant particip�
	public int numberOfPlayer;
	
	// Arguments suppl�mentaires
	public String additionalArgs;
		
	public Statut(int type, int numberOfPlayer, String additionalArgs)
	{
		
		this.type = type;
		this.numberOfPlayer = numberOfPlayer;
		this.additionalArgs = additionalArgs;
		
	}
	
	
	
}
