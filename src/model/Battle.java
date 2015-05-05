package model;

import java.util.Observable;
import java.util.Random;

import model.Tiles.DesertGrass;
import model.Tiles.TallGrass;

public class Battle extends Observable{
	Map map;
	Pokemon pokemon;
	
	public Battle(Map map){
		this.map = map;
	    pokemon = generatePokemon();
	}
	
	private Pokemon generatePokemon(){
		Random randomGenerator = new Random();
		if(map.tileAtMeadow(map.getR(), map.getC()) instanceof TallGrass){
	        int encountered = randomGenerator.nextInt(11);
			
            if(encountered < 4)
                return new Scyther();
            
            if(encountered < 8)
                return new Dragonite();
            
            if(encountered < 10)
                return new Venusaur();
		}
		
		if(map.tileAtMeadow(map.getR(), map.getC()) instanceof DesertGrass){
			
		}
		
		return new Mewtwo();
	}
	
	public Pokemon getPokemon(){
		return pokemon;
	}
}
