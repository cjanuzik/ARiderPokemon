package model;

public class Battle {
	Pokemon pokemon = null;
	Character character = null;
	int[] result = new int[4];
	/*
	 * constructor
	 */
	public Battle(Pokemon p, Character c){
		pokemon = p;
		character = c;
		result[0] = pokemon.getRunChance();
		result[1] = pokemon.getCatchRate();
		result[2] = pokemon.getMaxTurns();
		//display();
	}
	/*
	 * throwbait
	 */
	public int[] throwBait(){
		result[0] -= result[0]/2;
		result[1] -= result[1]/2;
		result[2]--;
		result[3] = result(result[1], result[0]);
		
		return result;
		
	}
	
	public int[] throwRock(){
		result[0] += result[0]/2;
		result[1] += result[1]/2;
		result[2]--;
		result[3] = result(result[1], result[0]);
		
		return result;
		
	}
	
	/*
	 * returns the result of the fight
	 */
	public int result(int catchRate, int runChance){
		if(runChance > 100 || result[2] == 0){
			return -1;    //pokemon ran away
		}
		
		else if(catchRate >= 90){
			return 1;    //pokemon caught
		}
		else 
		return 0;
	}
	
	
}
