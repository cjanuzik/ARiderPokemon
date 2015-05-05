<<<<<<< HEAD
package model;


import java.util.ArrayList;
import java.util.List;

import controller.GameView;

public class Inventory {
	private static int numOfBalls = 30;
	private static List<Pokemon> pokemon = new ArrayList<Pokemon>();
	private static boolean rockSmashUnlocked = false;
	private static boolean surfUnlocked = false;
	private static int steps = 500;
	
	public static void addPokemon(Pokemon toAdd)
	{
		pokemon.add(toAdd);
		
	}
	
	public static boolean updateBallCount(int ball)
	{
		int temp = numOfBalls + ball;
		if(temp > 0)
		{
			numOfBalls += ball;
			
			return true;
		}
		if(temp == 0){
			numOfBalls += ball;
			GameView.addSummaryPanel();
			return true;
		}
		else 
		    return false;
	}
	
	public static void takeAStep(){
		steps--;
		if(steps <= 0){
			GameView.addSummaryPanel();
		}
	}
	public static boolean containsPokemon(Pokemon toCheck)
	{
		return pokemon.contains(toCheck);
	}
	
	public int getNumOfPokemon()
	{
		return pokemon.size();
	}
	
	public static List<Pokemon> listPokemon()
	{
		return pokemon;
	}
	
	public static boolean getSurfUnlocked()
	{
		return surfUnlocked;
	}
	
	public static boolean getRockSmashUnlocked()
	{
		return rockSmashUnlocked;
	}
	public static void setSurfUnlocked(boolean value)
	{
		surfUnlocked = value;
	}
	public static void setRockSmashUnlocked(boolean value)
	{
		rockSmashUnlocked = value;
	}
	public static int getBalls()
	{
		return numOfBalls;
	}
	public static int getSteps(){
		return steps;
	}
}

=======
<<<<<<< HEAD
package model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private static int numOfBalls = 30;
	private List<Pokemon> pokemon = new ArrayList<Pokemon>();
	private static boolean rockSmashUnlocked = false;
	private static boolean surfUnlocked = false;
	private static int steps = 500;
	
	public boolean addPokemon(Pokemon toAdd)
	{
		if(pokemon.contains(toAdd))
			return false;
		
		pokemon.add(toAdd);
		return true;
	}
	
	public static boolean updateBallCount(int ball)
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
	
	public static void takeAStep(){
		steps--;
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
	
	public static boolean getSurfUnlocked()
	{
		return surfUnlocked;
	}
	
	public static boolean getRockSmashUnlocked()
	{
		return rockSmashUnlocked;
	}
	public static void setSurfUnlocked(boolean value)
	{
		surfUnlocked = value;
	}
	public static void setRockSmashUnlocked(boolean value)
	{
		rockSmashUnlocked = value;
	}
	public static int getBalls()
	{
		return numOfBalls;
	}
	public static int getSteps(){
		return steps;
	}
}

=======
package model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private static int numOfBalls = 30;
	private List<Pokemon> pokemon = new ArrayList<Pokemon>();
	private static boolean rockSmashUnlocked = false;
	private static boolean surfUnlocked = false;
	private static int steps = 500;
	
	public boolean addPokemon(Pokemon toAdd)
	{
		if(pokemon.contains(toAdd))
			return false;
		
		pokemon.add(toAdd);
		return true;
	}
	
	public static boolean updateBallCount(int ball)
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
	
	public static void takeAStep(){
		steps--;
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
	
	public static boolean getSurfUnlocked()
	{
		return surfUnlocked;
	}
	
	public static boolean getRockSmashUnlocked()
	{
		return rockSmashUnlocked;
	}
	public static void setSurfUnlocked(boolean value)
	{
		surfUnlocked = value;
	}
	public static void setRockSmashUnlocked(boolean value)
	{
		rockSmashUnlocked = value;
	}
	public static int getBalls()
	{
		return numOfBalls;
	}
	public static int getSteps(){
		return steps;
	}
}

>>>>>>> 6cb403aa49db4513a4e8374dae4f672ff8f11acb
>>>>>>> ef29f91423c64a8cf660804f35762efe7290f15b
