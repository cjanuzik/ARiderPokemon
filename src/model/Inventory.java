package model;


import java.util.ArrayList;
import java.util.List;

import controller.ARiderPokemonController;

/**
 * this class manages the inventory of the player. It consists of everything that the player picks up on the map, wins or pre-occupied things
<<<<<<< HEAD
=======
 * @author Chris
>>>>>>> 90a810ba63ebb86dcd37cda1d9801cbd3639e867
 *
 */
public class Inventory {
	private static int numOfBalls = 30;
	private static List<Pokemon> pokemon = new ArrayList<Pokemon>();
	private static boolean rockSmashUnlocked = false;
	private static boolean surfUnlocked = false;
	private static int steps = 500;
	/**
	 * adds the pokemon to the list of pokemons
	 * @param toAdd
	 */
	public static void addPokemon(Pokemon toAdd)
	{
		pokemon.add(toAdd);
		
		//if(toAdd.getName().equals("Mewtwo") && HomePanel.getWinCondition() == HomePanel.MEWTWO_WIN){
			ARiderPokemonController.addSummaryPanel();
		//}
		
	}
	/**
	 * updates the ball count and returns true or false which depends on updating the count
	 * @param ball
	 * @return true/false
	 * @throws NotEnoughBallsException
	 */
	public static boolean updateBallCount(int ball) throws NotEnoughBallsException{
		int temp = numOfBalls + ball;
		if(temp > 0)
		{
			numOfBalls += ball;
			
			return true;
		}
		if(temp == 0){
			numOfBalls += ball;
			throw new NotEnoughBallsException();
		}
		else 
		    return false;
	}

	/**
	 * reduces the no. of steps taken. basically decrements the the step count after every step
	 */
	public static boolean hasMewtwo(){
		for(int i = 0; i < pokemon.size(); i++){
			if(pokemon.get(i).getName() == "Mewtwo"){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Reduces steps by 1 and throws out of steps exception when 0 steps left
	 * @throws OutOfStepsException
	 */
	public static void takeAStep() throws OutOfStepsException{
		steps--;
		if(steps <= 0){
			throw new OutOfStepsException();
		}
	}
	/**
	 * checks if the pokemon is contained in the list and returns true if it is in the list and false if it is not
	 * @param toCheck
	 * @return true/false
	 */
	public static boolean containsPokemon(Pokemon toCheck)
	{
		return pokemon.contains(toCheck);
	}
	/**
	 * returns the no. of pokemons in the list
	 * @return pokemon.size()
	 */
	public int getNumOfPokemon()
	{
		return pokemon.size();
	}
	/**
	 * returns the list of pokemons
	 * @return pokemon
	 */
	public static List<Pokemon> listPokemon()
	{
		return pokemon;
	}
	/**
	 * returns if the surf ability has been unlocked
	 * @return surfUnlocked
	 */
	public static boolean getSurfUnlocked()
	{
		return surfUnlocked;
	}
	/**
	 * returns if the rock smash ability has been unlocked
	 * @return rockSmashUnlocked
	 */
	public static boolean getRockSmashUnlocked()
	{
		return rockSmashUnlocked;
	}
	/**
	 * sets the surf ability passed in the parameter
	 * @param value
	 */
	public static void setSurfUnlocked(boolean value)
	{
		surfUnlocked = value;
	}
	/**
	 * sets the rock smash ability passed in the parameter
	 * @param value
	 */
	public static void setRockSmashUnlocked(boolean value)
	{
		rockSmashUnlocked = value;
	}
	/**
	 * returns the no. of balls
	 * @return numOfBalls
	 */
	public static int getBalls()
	{
		return numOfBalls;
	}
	/**
	 * returns the no. of steps
	 * @return steps
	 */
	public static int getSteps(){
		return steps;
	}
}

