package _02_Rainbow_Zombie_Conga_Line;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {
    
    /*
     * You are hosting a rainbow zombie conga dance party! Zombies are not very
     * smart(maybe that's why they crave brains) and need your help to direct
     * them through the choreography.
     * 
     * Each method is a dance move you will need to implement.
     * 
     * When you think you've gotten your zombies trained well enough you can
     * start the party by running the main method in RainbowZombieDanceParty and
     * typing how many rounds you want in the console to see if they followed
     * your choreography correctly.
     * 
     * Note: The party will always start with a rainbow brains and every 5
     * rounds the head and tail of the dance line will be removed.
     */

    private LinkedList<Zombie> congaLine;
    private ZombieHatColor[] zombieHats;

    public RainbowZombieCongaLine() {

        congaLine = new LinkedList<Zombie>();
        zombieHats = ZombieHatColor.values();

    }

    // Make the passed in zombie the first Zombie in the conga line!
    public void engine(Zombie dancer) {
    	Node<Zombie> zombie = new Node<Zombie>(dancer);
    	congaLine.setHead(zombie);
    }

    // Make the passed in zombie the last Zombie in the conga line!
    public void caboose(Zombie dancer) {
    	Node<Zombie> zombie = new Node<Zombie>(dancer);
    	congaLine.setTail(zombie);
    }

    // Place the zombie at the designated position in the conga line!
    public void jumpInTheLine(Zombie dancer, int position) {
    	Node<Zombie> next = congaLine.getHead();
    	Node<Zombie> zombie = new Node<Zombie>(dancer);
    	Node<Zombie> prev = congaLine.getHead();
    	int index = 0;
    	while(next != null) {
    		if(index == position-1) {
    			prev = next;
    		}
    		else if(index == position) {
    			next.setPrev(prev);
    			next.setValue(zombie.getValue());
    			next.setNext(prev.getNext());
    			
    			prev.setNext(zombie);
    		}
    		else if(index == position+1) {
    			next.setPrev(zombie);
    		}
    		next = next.getNext();
    		index++;
    	}
    }

    /*
     * Remove all zombies with the same hat color as the passed in zombie from
     * the conga line!
     */
    public void everyoneOut(Zombie dancer) {
    	Node<Zombie> next = congaLine.getHead();
    	int index = 0;
    	while(next != null) {
    		if(next.getValue().getZombieHatColor() == dancer.getZombieHatColor()) {
    			congaLine.remove(index);
    		}
    		next = next.getNext();
    		index++;
    	}
    }

    /*
     * Remove the first zombie with the same hat color as the passed in zombie
     * from the conga line!
     */
    public void youAreDone(Zombie dancer) {
    	Node<Zombie> next = congaLine.getHead();
    	int index = 0;
    	while(next != null) {
    		if(next.getValue().getZombieHatColor() == dancer.getZombieHatColor()) {
    			congaLine.remove(index);
    			break;
    		}
    		next = next.getNext();
    		index++;
    	}
    }

    /*
     * Make two more zombies with the same hat color as the passed in zombie and
     * add one to the front, one to the end and one in the middle.
     */
    public void brains(Zombie dancer) {
    	Zombie zombie = new Zombie(dancer.getZombieHatColor());
    	engine(zombie);
    	caboose(zombie);
    	jumpInTheLine(zombie, congaLine.size()/2);
    }

    /*
     * Add the passed in zombie to the front and then add one zombie of each hat
     * color to the end of the line.
     */
    public void rainbowBrains(Zombie dancer) {
    	Zombie zombie;
    	engine(dancer);
    	ZombieHatColor colors[] = ZombieHatColor.values();
    	for(ZombieHatColor color : colors) {
    		zombie = new Zombie(color);
    		congaLine.add(zombie);
    	}
    }

    public LinkedList<Zombie> getCongaLine() {
        return congaLine;
    }
}
