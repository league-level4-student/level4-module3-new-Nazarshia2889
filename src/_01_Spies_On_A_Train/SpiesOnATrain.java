package _01_Spies_On_A_Train;

import java.util.HashMap;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

    /*
     * A spy has made off with important intel from your intelligence agency!
     * You know the spy is somewhere on this train(LinkedList). Your job is to
     * find the suspect that matches the description given to you by the list of
     * clues(the array).
     * 
     * Walk through the train, questioning each of the passengers about what
     * they have seen and return the name of the most likely suspect.
     * 
     * The results are randomly generated each time so you should have a general
     * case solution that carefully compares the clues to each passenger's
     * testimony. Remember to use String methods to break up the passengers'
     * statements.
     */
    String findIntel(LinkedList<TrainCar> train, String[] clues) {
    	Node<TrainCar> next = train.getHead();
    	HashMap<String, Integer> suspects = new HashMap<String, Integer>();
    	
    	while(next != null) {
    		String questioning = next.getValue().questionPassenger();
    		String evidence = "";
    		String suspect = "";
    		if(questioning.contains("eating")) {
    			int indexFirst = questioning.indexOf("saw") + 4;
    			int indexLast = questioning.indexOf("eating");
    			evidence = questioning.substring(indexLast, questioning.length()-1);
    			suspect = questioning.substring(indexFirst, indexLast-1);
    		}
    		else if(questioning.contains("speaking")) {
    			int indexFirst = questioning.indexOf("saw") + 4;
    			int indexLast = questioning.indexOf("speaking");
    			evidence = questioning.substring(indexLast, questioning.length()-1);
    			suspect = questioning.substring(indexFirst, indexLast-1);
    		}
    		else if(questioning.contains("carrying")) {
    			int indexFirst = questioning.indexOf("saw") + 4;
    			int indexLast = questioning.indexOf("carrying");
    			evidence = questioning.substring(indexLast, questioning.length()-1);
    			suspect = questioning.substring(indexFirst, indexLast-1);
    		}
    		
    		for(String clue : clues) {
    			if(evidence.equals(clue)) {
    				if(suspects.containsKey(suspect)) {
    					suspects.put(suspect, suspects.get(suspect) + 1);
    				}
    				else { 
    					suspects.put(suspect, 1);
    				}
    			}
    		}
    		
    		next = next.getNext();
    	}
    	int max = 0;
    	String spy = "";
    	for(String i : suspects.keySet()) {
    		if(suspects.get(i) > max) {
    			max = suspects.get(i);
    			spy = i;
    		}
    	}
        return spy;

    }

}
