package model;

import java.util.LinkedList;
import java.util.List;

public class Inventory {
	private int noOfPokeballs;
	private List<Pokemon> pokemon;
	private boolean rockDestroyer, surfAbility;
	
	public Inventory()
	{
		pokemon = new LinkedList<Pokemon>;
		noOfPokeballs = 0;
		rockDestroyer = false;
		surfAbility = false;
	}
	
	public boolean addPokemon(Pokemon toAdd)
	{
		if(pokemon.contains(toAdd))
			return false;
		
		pokemon.add(toAdd);
		return true;
	}
	public boolean removePokemon(Pokemon toRemove)
	{
		if(pokemon.contains(toRemove))
		{
			pokemon.remove(toRemove);
			return true;
		}
		return false;
	}
	
	public void updateBallCount(int ball)
	{
		noOfPokeballs+=ball;
	}
	public boolean containsPokemon(Pokemon toCheck)
	{
		return pokemon.contains(toCheck);
	}
	
	public int getNumberPokemon()
	{
		return pokemon.size();
	}
	
	public List<Pokemon> listPokemon()
	{
		return pokemon;
	}
	
	public boolean isSurfer()
	{
		return surfAbility;
	}
	
	public boolean isRockDestroyer()
	{
		return rockDestroyer;
	}
	public void setSurfer(boolean value)
	{
		surfAbility = value;
	}
	public void setRockDestroyer(boolean value)
	{
		rockDestroyer = value;
	}
}

