package model;

import java.util.LinkedList;
import java.util.List;

public class Inventory {
	private int numOfBalls;
	private List<Pokemon> pokemon;
	private Pokedex pokedex;
	private boolean rockSmashUnlocked, surfUnlocked;
	
	public Inventory()
	{
		pokemon = new LinkedList<Pokemon>();
		numOfBalls = 0;
		rockSmashUnlocked = false;
		surfUnlocked = false;
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
	
	public boolean updateBallCount(int ball)
	{
		int temp = numOfBalls + ball;
		if(temp>0)
		{
			numOfBalls+=ball;
			return true;
		}
		else 
			return false;
	}
	public boolean containsPokemon(Pokemon toCheck)
	{
		return pokemon.contains(toCheck);
	}
	
	public int getNumOfPokemon()
	{
		return pokemon.size();
	}
	
	public List<Pokemon> listPokemon()
	{
		return pokemon;
	}
	
	public boolean getSurfUnlocked()
	{
		return surfUnlocked;
	}
	
	public boolean isRockDestroyer()
	{
		return rockSmashUnlocked;
	}
	public void setSurferUnlocked(boolean value)
	{
		surfUnlocked = value;
	}
	public void setRockDestroyer(boolean value)
	{
		rockSmashUnlocked = value;
	}
	public int getBalls()
	{
		return numOfBalls;
	}
}

