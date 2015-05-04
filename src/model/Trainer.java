package model;

public class Trainer {
	private String name;
	private int steps;
	private Inventory inventory;
	private int balls;
	
    public Trainer(String name){
    	this.name = name;
    	steps = 500;
    	inventory = new Inventory();
    	balls = 30;
    }
    
    public int getSteps(){
    	return steps;
    }
    
    public int getBalls(){
    	return balls;
    }
    
    public Inventory getInventory(){
    	
    }
}
