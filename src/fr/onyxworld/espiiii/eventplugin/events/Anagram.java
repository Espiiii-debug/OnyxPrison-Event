package fr.onyxworld.espiiii.eventplugin.events;

import java.util.ArrayList;
import java.util.List;

// Event Anagram
public class Anagram 
{

	

	
	public static String randomLetters(String w){
        List<Character> chara = new ArrayList<Character>();
        for(char c:w.toCharArray()){
            chara.add(c);
        }
        StringBuilder output = new StringBuilder(w.length());
        while(chara.size()!=0){
            int randPicker = (int)(Math.random()*chara.size());
            output.append(chara.remove(randPicker));
        }
        return output.toString();
    }
	
}
