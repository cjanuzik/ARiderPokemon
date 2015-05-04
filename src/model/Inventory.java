package model;

import java.util.LinkedList;
import java.util.List;

public class Inventory {
	private int numOfBalls;
	private List<Pokemon> pokemon;
	private boolean rockSmashUnlocked, surfUnlocked;
	private int steps;
	
	public Inventory()
	{
		pokemon = new LinkedList<Pokemon>();
		numOfBalls = 30;
		steps = 500;
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
	
	public boolean getRockSmashUnlocked()
	{
		return rockSmashUnlocked;
	}
	public void setSurferUnlocked(boolean value)
	{
		surfUnlocked = value;
	}
	public void setRockSmashUnlocked(boolean value)
	{
		rockSmashUnlocked = value;
	}
	public int getBalls()
	{
		return numOfBalls;
	}
	public int getSteps(){
		return steps;
	}
}

