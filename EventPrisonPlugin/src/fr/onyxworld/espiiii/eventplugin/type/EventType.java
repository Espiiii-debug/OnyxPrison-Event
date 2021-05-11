package fr.onyxworld.espiiii.eventplugin.type;

import java.util.ArrayList;

public class EventType 
{
	
	// Id de l'event
	public int id;
	
	// Titre de l'event
	public String title;
	
	// Description de l'event
	public String description;
	
	// Arguments de l'event
	public String arguments;
	
	// Fichier de l'event
	public String main;
	
	// Liste d'event possible :
	static ArrayList<EventType> eventList = new ArrayList<EventType>();

	
	public EventType(int id, String title, String description, String arguments, String main)
	{
		
		
		
	}
	public static ArrayList<EventType> getEventList()
	{
		
		// Creation d'un event Anagram
		EventType anagramEvent = new EventType(1, "Anagrame", "Les joueurs recoivent un mot dont la position des lettres sont al�atoires. A eux de retrouver le mot d'origine.", "/event create anagram <word>", "fr.onyxworld.espiiii.eventplugin.events.Anagram");
		EventType questionEvent = new EventType(2, "Question", "Les joueurs doivent r�poondre � une question pos�e.", "/event create question <question> <r�ponse>", "fr.onyxworld.espiiii.eventplugin.events.Question");

		
		eventList.clear();
		
		// D�claration de l'event 1
		eventList.add(anagramEvent);
		
		// D�claration de l'event 2
		eventList.add(questionEvent);
		
		
		return eventList;
	}
}
