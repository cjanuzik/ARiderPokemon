package model;
import java.util.Observable;

import javax.swing.Action;


public abstract class Pokemon extends Observable{
    private String name;
    private int dexNum;
    private String type;
    private int rarity;
    private int HP;
    private int runChance = 20; //defaults runChance to 20%
    private int maxTurns = 7; //defaults maxTurns to 7
    private int catchRate = 40;//defaults catchRate to 40%
    
    public Pokemon(String pkmnName, int pkmnDexNum, String pkmnType, int pkmnRarity, int pkmnHP){
    	name = pkmnName;
    	dexNum = pkmnDexNum;
    	type = pkmnType;
    	rarity = pkmnRarity;
    	HP = pkmnHP;
    	switch(pkmnRarity){
	        case 0: runChance = 20; //Sets common runChance to 20%
	        		maxTurns = 7; //Sets common maxTurns to 7
	        		catchRate = 40;//Sets common catchRate to 40%
	                break;
	                
	        case 1: runChance = 33; //Sets uncommon runChance to 33%
	                maxTurns = 5; //Sets uncommon runChance to 5
	                catchRate = 30;//Sets uncommon catchRate to 30%
	                break;
	                
	        case 2: runChance = 50; //Sets unique runChance to 50%
	                maxTurns = 3; //Sets unique maxTurns to 3
	                catchRate = 20;//Sets unique catchRate to 20%
	                break;
    	}
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
    public void changeRates(Action action){
    	if(action instanceof throwRock){
    		runChance += runChance/2;
    		catchRate += catchRate/2;
    		if(runChance > 100){
    			runChance = 100;
    		}
    		
    		if(catchRate >= 90){
    			catchRate = 90;
    		}
    	}
    	
    	if(action instanceof throwBait){
    		runChance -= runChance/2;
    		catchRate -= catchRate/2;
    		if(runChance <= 0){
    			runChance = 5;
    		}
    		if(catchRate <= 0){
    			catchRate = 5;
    		}
    	}
    }
  
}
