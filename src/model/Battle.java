package model;

import java.util.Observable;
import java.util.Random;

import model.Tiles.DesertGrass;
import model.Tiles.TallGrass;

public class Battle extends Observable{
	Map map;
	Pokemon pokemon;
	int turns;
	
	public Battle(Map map){
		this.map = map;
	    pokemon = generatePokemon();
	    turns = 0;
	}
	
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
	public Pokemon getPokemon(){
		return pokemon;
	}
	
	//Returns if the Pokemon was caught
	public boolean isCaught(){
		Random randomGenerator = new Random();
		int caught = randomGenerator.nextInt(100);
		
		if(caught < pokemon.getCatchRate())
		    return true;
		
		return false;
	}
	
	public boolean checkTurns(){
		turns++;
		if(turns == pokemon.getMaxTurns())
			return true;
		return false;
	}
	
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
		
		if(checkTurns())
			return true;
		
		if(ran < pokemon.getRunChance())
			return true;
		
		return false;
	}
}
