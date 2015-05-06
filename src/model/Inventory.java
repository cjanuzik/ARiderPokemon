package model;


import java.util.ArrayList;
import java.util.List;

import view.HomePanel;
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
		
		//if(toAdd.getName().equals("Mewtwo") && HomePanel.getWinCondition() == HomePanel.MEWTWO_WIN){
			GameView.addSummaryPanel();
		//}
		
	}
	
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
	
	public static boolean hasMewtwo(){
		for(int i = 0; i < pokemon.size(); i++){
			if(pokemon.get(i).getName() == "Mewtwo"){
				return true;
			}
		}
		return false;
	}
	
	public static void takeAStep() throws OutOfStepsException{
		steps--;
		if(steps <= 0){
			throw new OutOfStepsException();
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

