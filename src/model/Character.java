package model;


public class Character {
	String name;
	Inventory inventory = null;
	int steps;
	//static Sprite sprite= null;
	
	/*
	 * 
	 */
	public Character(String n, Inventory i, int s){
		name = n;
		inventory= i;
		steps = s;
		
	}
	public String getName(){
		return name;
	}
	/*
	 * 
	 */
	public Inventory getInventory(){
		return inventory;
	}
	/*
	 * 
	 */
	public int getSteps(){
		return steps;
	}
	
	/*
	 * 
	 */
	public void updateSteps(int step){
		steps+=step;
	}

	
	
	

}
