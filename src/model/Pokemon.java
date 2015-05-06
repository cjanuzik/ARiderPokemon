package model;
import java.util.Observable;

/**
 * abstract class used to design the pokemon. It sets everything about the piokemon like, rarity, HP, namerunChance, catchRate etc
 * @author Aakash
 *
 */
public abstract class Pokemon extends Observable{
    private String name;
    private int dexNum;
    private String type;
    private int rarity;
    private int HP;
    private int runChance; //defaults runChance to 20%
    private int maxTurns; //defaults maxTurns to 7
    private int catchRate;//defaults catchRate to 40%
    
    /**
     * constructor to set the runchance maxTurns and catchRate according to the pokemon's rarity
     * @param pkmnName
     * @param pkmnDexNum
     * @param pkmnType
     * @param pkmnRarity
     * @param pkmnHP
     */
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
    /**
     * adjusts the run chance
     * @param adjust
     */
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
    }
    /**
     * adjusts the catch rate
     * @param adjust
     */
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
    }
    
    public String getName(){
    	return name;
    }
    
    /**
     * return dex Number
     * @return dexNum
     */
    public int getDexNum(){
    	return dexNum;
    }
    /**
     * returns the pokemon type
     * @return type
     */
    public String getType(){
    	return type;
    }
    
    /**
     * returns the pokemon's rarity
     * @return rarity
     */
    public int getRarity(){
    	return rarity;
    }
    /**
     * returns the pokemon's HP
     * @return HP
     */
    public int getHP(){
    	return HP;
    }
    /**
     * returns the pokemon's runChance
     * @return runChance
     */
    public int getRunChance(){
    	return runChance;
    }
    /**
     * returns the max turns
     * @return maxTurns
     */
    public int getMaxTurns(){
    	return maxTurns;
    }
    
    /**
     * returns the pokemon's CatchRate
     * @return catchRate
     */ 
    public int getCatchRate(){
    	return catchRate;
    }

    
  
}
