package model;


public class Character {
	String name;
	Inventory inventory = null;
	int steps;	
	/*
	 * Constructor to set values
	 */
	public Character(String n, Inventory i, int s){
		name = n;
		inventory= i;
		steps = s;
		
	}
	/*
	 * returns the name 
	 */
	public String getName(){
		return name;
	}
	/*
	 * adds pokemon to the inventory
	 */
	public void addPokemon(Pokemon p){
		inventory.addPokemon(p);
		
	}
	/*
	 * adds surfing ability to the character
	 */
	public void addSurfAbility(){
		inventory.setSurferUnlocked(true);
	}
	/*
	 * adds rock destroyer ability to the character
	 */
	public void addRockDestroyer(){
		inventory.setRockDestroyer(true);
	}
	/*
	 * 
	 */
	public Inventory getInventory(){
		return inventory;
	}
	/*
	 * returns the steps 
	 */
	public int getSteps(){
		return steps;
	}
	
	/*
	 * updates the steps 
	 */
	public void updateSteps(int step){
		steps+=step;
	}

	
	
	

}
