package model;

import java.util.Observable;
import java.util.Random;

import model.Tiles.DesertGrass;
import model.Tiles.TallGrass;

/**
 * performs all the calculation needed during the battle.
 * This class generates the probability for encountering the pokemon, sets the win conditions, decides if the pokemon has been caught or not
 * Basically, it perform everything needed for the battle, except the GUI
 * @author Aakash
 *
 */
public class Battle extends Observable{
	Map map;
	Pokemon pokemon;
	int turns;
	
	public Battle(Map map){
		this.map = map;
	    pokemon = generatePokemon();
	    turns = 0;
	}
	/**
	 * Decides which pokemon has been encountered and returns the pokemon.
	 * You can enounter a desert pokemon or grass pokemon or the rare pokemon which could be found in any part of the map, MewTwo
	 * @return pokemon
	 */
	private Pokemon generatePokemon(){
		Random randomGenerator = new Random();
		
		//Calculates which Pokemon was encountered in the Meadow
		if(map.tileAtMeadow(map.getR(), map.getC()) instanceof TallGrass){
	        int encountered = randomGenerator.nextInt(15);
			
            if(encountered < 6)
                return new Scyther();
            
            if(encountered < 12)
                return new Dragonite();
            
            if(encountered < 14)
                return new Venusaur();
		}
		
		//Calculates which Pokemon was encountered in the Desert
		
		if(map.tileAtMeadow(map.getR(), map.getC()) instanceof DesertGrass){
			int encountered = randomGenerator.nextInt(15);
			
			if(encountered < 4)
				return new Pidgeotto();
			
			if(encountered < 8)
				return new Pikachu();
			
			if(encountered < 12)
				return new Gengar();
			
			if(encountered < 14)
				return new Charizard();
		}
		
		//If no Pokemon was encountered, return a Mewtwo!
		return new Mewtwo();
	}
	
	//Returns which Pokemon is being battled
	/**
	 * Returns the pokemon in the battle
	 * @return pokemon
	 */
	public Pokemon getPokemon(){
		return pokemon;
	}
	
	//Returns if the Pokemon was caught
	/**
	 * returns if the pokemon was caught
	 * 
	 * @return true/false
	 */
	public boolean isCaught(){
		Random randomGenerator = new Random();
		int caught = randomGenerator.nextInt(100);
		
		if(caught < pokemon.getCatchRate())
		    return true;
		
		return false;
	}
	
	/**
	 * checks if the player has used the max turns given to him
	 * @return true/false
	 */
	public boolean checkTurns(){
		turns++;
		if(turns == pokemon.getMaxTurns())
			return true;
		return false;
	}
	
	/**
	 * determines if the pokemon ran away or not
	 * @return true/false
	 */
	public boolean pokemonRun(){
		Random randomGenerator = new Random();
		int caught = randomGenerator.nextInt(100);
		
		if(caught < pokemon.getRunChance())
		    return true;
		
		return false;
	}
	public boolean didRun(){
		Random randomGenerator = new Random();
		int ran = randomGenerator.nextInt(100);
		
		if(ran < pokemon.getRunChance())
			return true;
		
		return false;
	}
}
