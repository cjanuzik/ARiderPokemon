package model;
import java.util.Observable;


public abstract class Pokemon extends Observable{
    private String name;
    private int dexNum;
    private String type;
    private int rarity;
    private int HP;
    private int runChance; //defaults runChance to 20%
    private int maxTurns; //defaults maxTurns to 7
    private int catchRate;//defaults catchRate to 40%
    
    public Pokemon(String pkmnName, int pkmnDexNum, String pkmnType, int pkmnRarity, int pkmnHP){
    	name = pkmnName;
    	dexNum = pkmnDexNum;
    	type = pkmnType;
    	rarity = pkmnRarity;
    	HP = pkmnHP;
    	switch(pkmnRarity){
	        case 0: runChance = 20; //Sets common runChance to 20%
	        		maxTurns = 7; //Sets common maxTurns to 7
	        		catchRate = 30;//Sets common catchRate to 40%
	                break;
	                
	        case 1: runChance = 25; //Sets uncommon runChance to 33%
	                maxTurns = 5; //Sets uncommon runChance to 5
	                catchRate = 30;//Sets uncommon catchRate to 30%
	                break;
	                
	        case 2: runChance = 30; //Sets unique runChance to 50%
	                maxTurns = 3; //Sets unique maxTurns to 3
	                catchRate = 10;//Sets unique catchRate to 20%
	                break;
    	}
    }
    
    public void adjustRunChance(int adjust){
    	//Increases catchRate by 50% and sets to 90% if higher than 90%
    	if(adjust == 1){
    		runChance += runChance/2;
    		if(runChance > 90){
    			runChance = 90;
    		}
    	}
    	
    	//Decreases catchRate by 50% and sets to 10% if lower than 10%
    	if(adjust == -1){
    		runChance -= runChance/2;
    		if(runChance < 10)
    			runChance = 10;
    	}
    	
    	System.out.println("RunChance = " + runChance);
    }
    
    public void adjustCatchRate(int adjust){
    	//Increases catchRate by 50% and sets to 90% if higher than 90%
    	if(adjust == 1){
    		catchRate += catchRate/2;
    		if(catchRate > 90){
    			catchRate = 90;
    		}
    	}
    	
    	//Decreases catchRate by 50% and sets to 10% if lower than 10%
    	if(adjust == -1){
    		catchRate -= catchRate/2;
    		if(catchRate < 10)
    			catchRate = 10;
    	}
    	
    	System.out.println("CatchRate = " + catchRate);
    }
    
    public String getName(){
    	return name;
    }
    
    public int getDexNum(){
    	return dexNum;
    }
    
    public String getType(){
    	return type;
    }
    
    public int getRarity(){
    	return rarity;
    }
    
    public int getHP(){
    	return HP;
    }
    
    public int getRunChance(){
    	return runChance;
    }
    
    public int getMaxTurns(){
    	return maxTurns;
    }
    
    public int getCatchRate(){
    	return catchRate;
    }

    
  
}
